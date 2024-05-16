package com.hoho.shipping.customer;

public enum Gender {
    MALE {
        @Override
        public String toString() {
            return "남성";
        }
    },
    FEMALE {
        @Override
        public String toString() {
            return "여성";
        }
    }
}
