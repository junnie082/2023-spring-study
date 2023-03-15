package org.example.domain;

public enum DataType {
    TYPE_0(0),
    TYPE_1(1);

    private final int typeCode;

    DataType(int typeCode) {
        this.typeCode = typeCode;
    }

    public int getTypeCode() {
        return typeCode;
    }

    public static DataType convertCodeToType(int code) {  // 이 메서드는 chat gpt 가 알려줌.
        for (DataType type: DataType.values()) {
            if (type.typeCode == code) {
                return type;
            }
        }
        throw new IllegalArgumentException("[ERROR] 해당 데이터 타입이 존재하지 않습니다. ");
    }
}
