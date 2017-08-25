package org.lanqiao.web.util;

import javax.servlet.http.HttpServletRequest;

public class Requests {
  public static int getInt(HttpServletRequest request, String pName,
      int defaultValue) {
    String resultString = request.getParameter(pName);
    if (resultString == null) {
      return defaultValue;
    } else {
      try {
        return Integer.parseInt(resultString);
      } catch (Exception e) {
        return defaultValue;
      }
    }
  }

  private Requests() {
  }
}
