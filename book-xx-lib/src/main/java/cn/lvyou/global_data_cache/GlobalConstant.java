package cn.lvyou.global_data_cache;


public final class GlobalConstant {

  private GlobalConstant() {
  }

  // app全局共享的SharedPreferences
  public final static String APP_GLOBAL_SHARED_PREFERENCES = "DreamBook";

  /**
   * 性别
   * 
   * @author skyduck
   * 
   */
  public static enum SexEnum {
    // 无效
    Null(-1),

    // 保密
    Secrecy(0),
    //
    Man(1),
    //
    Woman(2);

    private int code;

    public int getCode() {
      return code;
    }

    private SexEnum(int code) {
      this.code = code;
    }

    public static SexEnum valueOfCode(int code) {
      for (SexEnum item : SexEnum.values()) {
        if (item.getCode() == code) {
          return item;
        }
      }

      return Null;
    }
  }
}
