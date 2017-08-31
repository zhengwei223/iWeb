package org.lanqiao.web.crud.entity;

import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.Date;
import java.util.Arrays;

import org.codehaus.jackson.map.annotate.JsonFilter;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;

/**
 *
 * @author zhengwei
 *
 */
public class User {
  private Integer id;
  private String name;
  private Integer age;
  private String email;
  private byte[] head;
  private String headUrl;
  @JSONField(name="birth",format="yyyy年mm月dd日")
  private Date birthday;
  private Double salary;
  private Date gmtCreate;
  private Date gmtModified;
//  用指定的Serializer来对本字段进行定制序列化
  @JSONField(serializeUsing=ActiveValueSerializer.class)
  private Boolean active;
  private Integer roleId;



  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public byte[] getHead() {
    return head;
  }

  public void setHead(byte[] head) {
    this.head = head;
  }

  public String getHeadUrl() {
    return headUrl;
  }

  public void setHeadUrl(String headUrl) {
    this.headUrl = headUrl;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public Double getSalary() {
    return salary;
  }

  public void setSalary(Double salary) {
    this.salary = salary;
  }

  public Date getGmtCreate() {
    return gmtCreate;
  }

  public void setGmtCreate(Date gmtCreate) {
    this.gmtCreate = gmtCreate;
  }

  public Date getGmtModified() {
    return gmtModified;
  }

  public void setGmtModified(Date gmtModified) {
    this.gmtModified = gmtModified;
  }

  public Boolean isActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public Integer getRoleId() {
    return roleId;
  }

  public void setRoleId(Integer roleId) {
    this.roleId = roleId;
  }


  @Override
  public String toString() {
    return "User [id=" + id + ", name=" + name + ", age=" + age + ", email="
        + email + ", head=" + Arrays.toString(head) + ", headUrl=" + headUrl
        + ", birthday=" + birthday + ", salary=" + salary + ", gmtCreate="
        + gmtCreate + ", gmtModified=" + gmtModified + ", active=" + active
        + ", roleId=" + roleId + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    User other = (User) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }
  // 实现阿里提供的序列化器
  public static class ActiveValueSerializer implements ObjectSerializer{

  @Override
  public void write(JSONSerializer serializer, Object value, Object fieldName,
      Type fieldType, int features) throws IOException {
    Boolean flag = (Boolean) value;
    if (flag) {
      serializer.write("是");
    }else {
      serializer.write("否");
    }
  }
  
}
}
