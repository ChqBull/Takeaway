package com.jk.bean;

import lombok.Data;

import java.io.Serializable;
@Data
public class address implements Serializable {
          private String id;
          private String address;
          private String addressStatus;
          private String user_id;
}
