package com.neusoft.elm.po;

public class OrderDetailet {
	 private Integer orderId;
	    private Integer foodId;
	    private Integer quantity;
	    //���һ������ʳƷ
	    private Food food;
		public Integer getOrderId() {
			return orderId;
		}
		public void setOrderId(Integer orderId) {
			this.orderId = orderId;
		}
		public Integer getFoodId() {
			return foodId;
		}
		public void setFoodId(Integer foodId) {
			this.foodId = foodId;
		}
		public Integer getQuantity() {
			return quantity;
		}
		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}
		public Food getFood() {
			return food;
		}
		public void setFood(Food food) {
			this.food = food;
		}
	    
}
