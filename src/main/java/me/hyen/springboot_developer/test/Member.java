//package me.hyen.springboot_developer.test;
//
//import jakarta.persistence.*;
//import lombok.AccessLevel;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@AllArgsConstructor
//@Getter
//@Entity
//public class Member {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", updatable = false)
//    private Long id;
//    @Column(name = "name", nullable = false)
//    private String name;
//
//    public Member(String name) {
//        this.name = name;
//    }
//
//    public void changeName(String name) {
//        this.name = name;
//    }
//
//
//
//}