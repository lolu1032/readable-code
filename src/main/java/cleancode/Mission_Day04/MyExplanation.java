//package cleancode.Mission_Day04;
//
//public class MyExplanation {
//    public boolean validateOrder(Order order) {
//        if(order.getItems().size() == 0) {
//            log.info("주문 항목이 없습니다.");
//            return false;
//        }else {
//            return validateOrderDetails(order);
//        }
//        return true;
//    }
//
//    private static boolean validateOrderDetails(Order order) {
//        if(hasNonZeroTotalPrice(order)) {
//            return isCustomerInfoPresent (order);
//        }
//        log.info("올바르지 않은 총 가격입니다.");
//        return false;
//    }
//
//    private static boolean isCustomerInfoPresent (Order order) {
//        if(order.hasCustomerInfo()) {
//            return true;
//        }
//        log.info("사용자 정보가 없습니다.");
//        return false;
//    }
//
//    private static boolean hasNonZeroTotalPrice(Order order) {
//        return order.getTotalPrice() > 0;
//    }
//}
