package wow.grmr.global.common;

public enum Area {

    te(1),
    인천(2),
    대전(3),
    대구(4),
    광주(5),
    부산(6),
    울산(7),
    세종(8),
    경기(31),
    강원(32),
    충북(33),
    충남(34),
    경북(35),
    경남(36),
    전북(37),
    전남(38),
    제주(39);

    private final int code;

    Area(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
    

}