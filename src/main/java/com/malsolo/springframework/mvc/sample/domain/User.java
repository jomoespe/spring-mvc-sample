package com.malsolo.springframework.mvc.sample.domain;

import com.google.common.base.Objects;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jbeneito
 */
@XmlRootElement
public class User {

    private Long id;
    private String name, phone, email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("name", name)
                .add("phone", phone)
                .add("email", email)
                .toString();
    }

}
