package com.javaweb.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "role")
@Getter
@Setter
public class RoleEntity extends BaseEntity {

    private static final long serialVersionUID = -6525302831793188081L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="code")
    private String code;


    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<UserEntity> user = new ArrayList<>();

//    @OneToMany(mappedBy="roles",fetch = FetchType.LAZY)
//    private List<UserRoleEntity> userRoleEntities = new ArrayList<>();

    public List<UserEntity> getUsers() {
        return user;
    }

    public void setUsers(List<UserEntity> users) {
        this.user = users;
    }

}
