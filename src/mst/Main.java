package mst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;



public class Main {
        public static void main(String[] agrv){
            set();
            while (true){
                System.out.println("--------欢迎来到动物信息管理系统--------");
                System.out.println("1 查看所有动物");
                System.out.println("2 添加动物");
                System.out.println("3 删除动物");
                System.out.println("4 修改动物");
                System.out.println("5 按年龄降序查看所有动物");
                System.out.println("6 退出动物信息管理系统");
                System.out.println("请输入你的选择：");
                System.out.println("------------------------------------");
                Scanner scanner = new Scanner(System.in);
                Integer choice = scanner.nextInt();
                switch (choice){
                    case 1:
                        findAllAnimal();
                        break;
                    case 2:
                        addAnimal();
                        break;
                    case 3:
                        deleteAnimal();
                        break;
                    case 4:
                        updataAnimal();
                        break;
                    case 5:
                        orderByAge();
                        break;
                    case 6:
                        System.out.println("程序已经成功退出，谢谢你的使用.按任意键继续...");
                        break;
                    default:
                        System.out.println("暂时未具备相应功能，请回主菜单重新选择.");
                        break;
                }
            }
        }

    private static void set() {
        Animal animalOne = new Animal("2019","牛","雄",2);
        Animal animalTwo = new Animal("2020","羊","雌",1);
        Animal.getList().add(animalOne);
        Animal.getList().add(animalTwo);
    }

    /*
         * 修改动物的思路：键盘录入一个种类，到集合中去查找，如果有就修改该动物
         */
        public static void updataAnimal(){
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入你要修改的动物id：");
            String id = sc.nextLine();
            int index = -1;
            for (int x = 0; x < Animal.getList().size(); x++) {
                Animal s = Animal.getList().get(x);
                if (s.getId().equals(id)) {
                    index = x;
                    break;
                }
            }
            if (index == -1) {
                System.out.println("你要修改的id对应的动物信息不存在,请重新选择");
            }
            else {
                System.out.println("请输入id对应的新种类：");
                String various = sc.nextLine();
                System.out.println("请输入新动物的性别：");
                String sex = sc.nextLine();
                System.out.println("请输入新动物的年龄");
                Integer age = sc.nextInt();
                // 创建动物对象
                Animal s = new Animal();
                s.setId(id);
                s.setVarious(various);
                s.setSex(sex);
                s.setAge(age);
                // 修改集合中的动物对象
                Animal.getList().set(index, s);
                // 给出提示
                System.out.println("修改信息成功!");
            }
        }
        //思路相似 删除动物方法
        public static void deleteAnimal() {
            // 创建键盘录入对象
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入你要删除的动物的id：");
            String id = sc.nextLine();
            // 定义一个索引
            int index = -1;
            // 遍历集合
            for (int x = 0; x < Animal.getList().size(); x++) {
                // 获取到每一个动物对象
                Animal s = Animal.getList().get(x);
                // 拿这个动物对象的id和键盘录入的id进行比较
                if (s.getId().equals(id)) {
                    index = x;
                    break;
                }
            }
            if (index == -1) {
                System.out.println("不好意思,你要删除的动物信息不存在,请回去重新选择");
            } else {
                Animal.getList().remove(index);
                System.out.println("删除动物成功");
            }
        }
        public static void addAnimal() {
            // 创建键盘录入对象
            Scanner sc = new Scanner(System.in);
            // 为了让id能够被访问到，我们就把id定义在了循环的外面
            String id;
            // 为了让代码能够回到这里，用循环
            while (true) {
                System.out.println("请输入动物ID：");
                // String id = sc.nextLine();
                id = sc.nextLine();
                // 判断id有没有被占用
                // 定义标记
                boolean flag = false;
                // 遍历集合
                for (int x = 0; x < Animal.getList().size(); x++) {
                    Animal s = Animal.getList().get(x);
                    if (s.getId().equals(id)) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    System.out.println("你输入的id已经被占用,请重新输入");
                }
                else {
                    break; // 结束循环
                }
            }
            System.out.println("请输入动物种类：");
            String various = sc.nextLine();
            System.out.println("请输入动物性别：");
            String sex = sc.nextLine();
            System.out.println("请输入动物年龄：");
            Integer age = sc.nextInt();
            // 创建对象
            Animal s = new Animal();
            s.setId(id);
            s.setVarious(various);
            s.setSex(sex);
            s.setAge(age);
            // 把动物对象作为元素添加到集合
            Animal.getList().add(s);
            // 给出提示
            System.out.println("添加动物成功");
        }
        public static void findAllAnimal()
        {
            // 首先来判断集合中是否有数据，如果没有数据，就给出提示，并让该方法不继续往下执行
            if (Animal.getList().size() == 0) {
                System.out.println("不好意思,目前没有动物信息可供查询,请重新选择.");
                return;
            }
            System.out.println("ID\t\t\t种类\t性别\t年龄");
            for (int x = 0; x < Animal.getList().size(); x++)
            {
                Animal s = Animal.getList().get(x);
                System.out.println(s.getId() + "\t"+ "\t"+s.getVarious() + "\t" +"\t"+ s.getSex()+"\t" +"\t"+s.getAge());
            }
        }
        private static void orderByAge() {
            if (Animal.getList().size() <= 0) {
                System.out.println("数据库为空!!");
                return;
            }

            // 克隆副本进行排序，避免对原始数据更改
            ArrayList<Animal> cList = (ArrayList<Animal>) Animal.getList().clone();

            // 排序
            Collections.sort(cList, new Comparator<Animal>() {

                public int compare(Animal s1, Animal s2) {
                    Integer result = Integer.compare(s2.getAge(), s1.getAge());
                    return result;
                }
            });

            // 打印输出年龄
            System.out.println("ID\t\t\t种类\t性别\t年龄");
            for(int i = 0; i < cList.size(); i++) {
                Animal s = cList.get(i);
                System.out.println(s.getId() + "\t" + "\t" + s.getVarious() + "\t" + "\t" + s.getSex()+ "\t" + "\t" +s.getAge());
            }
        }
    }

