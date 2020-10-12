package mst;

import java.util.ArrayList;

public class Animal {
        private String id;
        private String various;
        private String sex;
        private int age;
        private static ArrayList<Animal> list = new ArrayList<Animal>();
        public Animal(){}
        public Animal(String id,String various,String sex,int age){
            this.id = id;
            this.various = various;
            this.sex = sex;
            this.age = age;
        }
        public static ArrayList<Animal> getList(){
            return list;
        }
        public void setList(ArrayList<Animal> list){
            Animal.list = list;
        }
        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }
        public int getAge(){
            return this.age;
        }
        public String getVarious(){
            return this.various;
        }
        public String getSex(){
            return this.sex;
        }
        public void setAge(int age){
            this.age = age;
        }
        public void setVarious(String various){
            this.various = various;
        }
        public void setSex(String sex){
            this.sex = sex;
        }
    }

