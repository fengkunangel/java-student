package com.fengkun.study.thread;

/**
 * @author : fengkun
 * @date : 20-6-2
 */
public enum CountryEnum {

  ONE(1, "齐"),

  TWO(2, "楚"),

  THREE(3, "燕"),

  FORE(4, "赵"),

  FIVE(5, "魏"),

  SIX(6, "韩");

  private Integer retCode;

  private String retMsg;

  CountryEnum(Integer retCode, String retMsg) {
    this.retCode = retCode;
    this.retMsg = retMsg;
  }

  public Integer getRetCode() {
    return retCode;
  }

  public String getRetMsg() {
    return retMsg;
  }

  public static CountryEnum forEach_CountryEnum(int index) {

    for (CountryEnum countryEnum : CountryEnum.values()) {
      if (countryEnum.getRetCode() == index) {
        return countryEnum;
      }
    }
    return null;
  }
}
