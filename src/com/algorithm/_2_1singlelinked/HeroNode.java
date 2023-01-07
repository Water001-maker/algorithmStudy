package com.algorithm._2_1singlelinked;

//定义HeroNode，每个HeroNode对象就是一个节点
public class HeroNode {
    public int no;
    public String name;//名字
    public String nickname;//昵称
    public HeroNode next;//指向下一个节点

    //构造器
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    //为了显示方法，我们重新toString
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}