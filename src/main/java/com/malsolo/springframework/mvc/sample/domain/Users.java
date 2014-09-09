package com.malsolo.springframework.mvc.sample.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jbeneito
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Users {

    private List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void addUsers(Collection<User> users) {
        this.users.addAll(users);
    }

}
