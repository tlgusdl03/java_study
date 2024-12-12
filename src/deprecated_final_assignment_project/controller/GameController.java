//package final_assignment_prefare.controller;
//
//import final_assignment_prefare.manager.InventoryManager;
//import final_assignment_prefare.model.Customer;
//import final_assignment_prefare.service.CoffeeShopService;
//import final_assignment_prefare.service.CustomerService;
//
//public class GameController {
//    private CoffeeShopService coffeeShopService;
//    private CustomerService customerService;
//    private TimeController timeController;
//
//    // coffeeShopService의 budget이 양수라면 반복
//
//    // 오전 8시부터 오후 10시까지 영업을 함
//
//        // 그 사이동안 customerService에서 계속 손님을 만들어내고
//        // coffeeShopService로 손님을 처리함
//    public void runGame(){
//        System.out.println("게임을 시작합니다!");
//
//        timeController.setStartTIme(8);
//
//        while (timeController.getCurrentHour() < 22 && playerBudget > 0) {
//
//            Customer newCustomer = customerService.createCustomer();
//            coffeeShopService.makingCoffee(newCustomer);
//            timeController.addTime(1);
//        }
//    }
//}
