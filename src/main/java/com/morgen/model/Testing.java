//package com.morgen.model;
//
//import javax.persistence.*;
//import java.util.Objects;
//
//@Entity
//@Table(name = "testing")
//public class Testing {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String userName;
//
//   // private Theme theme;
//
//    private int resutls;
//
//    public Testing(
//            String userName,
////            Theme theme,
//            int resutls) {
//        this.userName = userName;
////        this.theme = theme;
//        this.resutls = resutls;
//    }
//
//    public Testing() {
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
////    public Theme getThemeId() {
////        return theme;
////    }
////
////    public void setThemeId(Theme theme) {
////        this.theme = theme;
////    }
//
//    public int getResutls() {
//        return resutls;
//    }
//
//    public void setResutls(int resutls) {
//        this.resutls = resutls;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Testing other = (Testing) obj;
//        if (this.userName != other.userName) {
//            return false;
//        }
//        if (!Objects.equals(this.userName, other.userName)) {
//            return false;
//        }
////        if (!Objects.equals(this.theme, other.theme)) {
////            return false;
////        }
//
//        return Objects.equals(this.id, other.id);
//    }
//
//
//    @Override
//    public int hashCode() {
//        int hash = 7;
//        hash = 79 * hash + Objects.hashCode(this.id);
//        hash = 79 * hash + Objects.hashCode(this.userName);
//        hash = 79 * hash + Objects.hashCode(this.resutls);
////        hash = 79 * hash + Objects.hashCode(this.theme);
//        return hash;
//    }
//
//    @Override
//    public String toString() {
//        return "Testing{" +
//                "id=" + id +
//                ", userName='" + userName + '\'' +
////                ", theme='" + theme + '\'' +
//                ", resutls=" + resutls +
//                '}';
//    }
//}
