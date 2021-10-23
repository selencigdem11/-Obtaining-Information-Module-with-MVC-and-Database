import java.util.Date;


class ApplicationPrice {

	private int AppId;
	private int Price;
        private int PaymentCheck;
        
	ApplicationPrice() {
		
	}

        public ApplicationPrice(int AppId, int Price) {
            this.AppId = AppId;
            this.Price = Price;
        }

        public ApplicationPrice(int AppId, int Price, int PaymentCheck) {
            this.AppId = AppId;
            this.Price = Price;
            this.PaymentCheck = PaymentCheck;
        }

        public int getAppId() {
            return AppId;
        }

        public void setAppId(int AppId) {
            this.AppId = AppId;
        }

        public int getPrice() {
            return Price;
        }

        public void setPrice(int Price) {
            this.Price = Price;
        }

        public int getPaymentCheck() {
            return PaymentCheck;
        }

        public void setPaymentCheck(int PaymentCheck) {
            this.PaymentCheck = PaymentCheck;
        }

	public Object getByName(String attributeName) {
		switch (attributeName) {
                    case "AppId": return AppId;
                     case "Price": return Price;
                    case "PaymentCheck": return PaymentCheck;
                    default: return null;
		}
	}

        @Override
        public String toString() {
            return AppId +  ", " + Price + ", " + PaymentCheck ;
        }
	
}
