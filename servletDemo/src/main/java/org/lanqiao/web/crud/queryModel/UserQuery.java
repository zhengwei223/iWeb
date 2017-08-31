package org.lanqiao.web.crud.queryModel;

import org.lanqiao.web.crud.entity.User;

public class UserQuery extends User {
  /*年龄范围*/
  private Integer ageScope;
  private Integer salaryScope;
  
  
  public String toString(){
    StringBuilder sb = new StringBuilder();
    dealAge(sb);
    dealSalary(sb);
    return sb.toString();
  }


  private void dealSalary(StringBuilder sb) {
    if (salaryScope!=null && salaryScope>0) {
      prepend(sb);
      switch (salaryScope) {
      case 1:
        sb.append(" salary between 0 and 2000");
        break;
      case 2:
        sb.append(" salary between 2000 and 5000");
        break;
      case 3:
        sb.append(" salary between 5000 and 8000");
        break;
      case 4:
        sb.append(" salary between 8000 and 10000");
        break;
      default:
        sb.append(" salary > 10000");
        break;
      }
    }
  }
  private void dealAge(StringBuilder sb) {
    if (ageScope!=null && ageScope>0) {
      prepend(sb);
      switch (ageScope) {
      case 1:
        sb.append(" age between 0 and 20");
        
        break;
      case 2:
        sb.append(" age between 20 and 40");
        break;
      case 3:
        sb.append(" age between 40 and 60");
        break;
      case 4:
        sb.append(" age between 60 and 80");
        break;
      default:
        sb.append(" age > 80");
        break;
      }
    }
  }


  private void prepend(StringBuilder sb) {
    if(sb.length()==0){
      sb.append(" where ");
    }else {
      sb.append(" and ");
    }
  }


  public Integer getAgeScope() {
    return ageScope;
  }


  public void setAgeScope(Integer ageScope) {
    this.ageScope = ageScope;
  }


  public Integer getSalaryScope() {
    return salaryScope;
  }


  public void setSalaryScope(Integer salaryScope) {
    this.salaryScope = salaryScope;
  }
}
