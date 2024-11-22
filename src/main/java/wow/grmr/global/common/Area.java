package wow.grmr.global.common;

public enum Area {

    SEOUL(1),
    INCHEON(2),
    DAEJEON(3),
    DAEGU(4),
    GWANGJU(5),
    BUSAN(6),
    ULSAN(7),
    SEJONG(8),
    GYEONGGI(31),
    GANGWON(32),
    CHUNGBUK(33),
    CHUNGMAN(34),
    GYEONGBUK(35),
    GYEONGNAM(36),
    JEONBUK(37),
    JEONNAM(38),
    JEJU(39);

    private final int code;

    Area(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
    

}
