package SalesTax;

enum Category {

        BOOK(true,false),
        MEDICAL_PRODUCTS(true,false),
        FOOD(true,false),
        OTHERS ( false , false),

        BOOKS_IMPORTED(true,true),
        MEDICICAL_PRODUCTS_IMPORTED(true,true),
        FOOD_IMPORTED(true,true),
        OTHERS_IMPORTED(false,true);

         private boolean isExempted;
         private boolean isImported;


        private Category(boolean exempted , boolean imported){
            isExempted = exempted;
            isImported = imported;
        }

        public boolean isImported(){
            return isImported;
        }
        public boolean isExempted(){
            return isExempted;
        }

    }

