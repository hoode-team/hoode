package vip.hoode.object.type;

public enum SwitchType {

    /**
     * 任何情况下可以正常访问
     */
    ON,
    /**
     * 可以正常访问但默认隐藏入口。
     */
    ON_HIDE,
    /**
     * 任何情况下都不能访问
     */
    OFF;

    public static final String ON_STATE = "ON";
    public static final String ON_HIDE_STATE = "ON_HIDE";
    public static final String OFF_STATE = "OFF";

}
