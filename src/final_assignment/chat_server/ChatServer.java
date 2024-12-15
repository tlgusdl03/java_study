package final_assignment.chat_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ChatServer {
    private static final int PORT = 9999;
    private static Map<String, Set<ClientHandler>> chatRooms = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Starting Chat Server on port " + PORT);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;
        private String currentRoom;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                out.println("Welcome to the Chat Server!");

                String message;
                while ((message = in.readLine()) != null) {
                    handleCommand(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                cleanup();
            }
        }

        private void handleCommand(String message) {
            if (message.startsWith("/create")) {
                String roomName = message.split(" ")[1];
                createRoom(roomName);
            } else if (message.startsWith("/join")) {
                String roomName = message.split(" ")[1];
                joinRoom(roomName);
            } else if (message.startsWith("/leave")) {
                leaveRoom();
            } else if (message.startsWith("/list")) {
                listRooms();
            } else {
                sendMessageToRoom(message);
            }
        }

        private void createRoom(String roomName) {
            synchronized (chatRooms) {
                if (chatRooms.containsKey(roomName)) {
                    out.println("Room already exists.");
                } else {
                    chatRooms.put(roomName, new HashSet<>());
                    out.println("Room created: " + roomName);
                }
            }
        }

        private void joinRoom(String roomName) {
            synchronized (chatRooms) {
                if (!chatRooms.containsKey(roomName)) {
                    out.println("Room does not exist.");
                    return;
                }

                leaveRoom(); // 이전 방 나가기
                chatRooms.get(roomName).add(this);
                currentRoom = roomName;
                out.println("Joined room: " + roomName);
            }
        }

        private void leaveRoom() {
            if (currentRoom != null) {
                synchronized (chatRooms) {
                    chatRooms.get(currentRoom).remove(this);
                    if (chatRooms.get(currentRoom).isEmpty()) {
                        chatRooms.remove(currentRoom);
                    }
                }
                currentRoom = null;
                out.println("Left the room.");
            }
        }

        private void listRooms() {
            synchronized (chatRooms) {
                if (chatRooms.isEmpty()) {
                    out.println("No rooms available.");
                } else {
                    out.println("Available rooms:");
                    for (String room : chatRooms.keySet()) {
                        out.println("- " + room);
                    }
                }
            }
        }

        private void sendMessageToRoom(String message) {
            if (currentRoom == null) {
                out.println("You are not in a room.");
                return;
            }
            synchronized (chatRooms) {
                for (ClientHandler client : chatRooms.get(currentRoom)) {
                    client.out.println(message);
                }
            }
        }

        private void cleanup() {
            try {
                if (currentRoom != null) {
                    leaveRoom();
                }
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
