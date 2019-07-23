package com.snayi.factory_pattern;

import java.util.Scanner;

/**
 * @Author: snayi
 * @CreateTime: 2019-07-23 20:53
 * @Description: 简单工厂模式
 * 构成：一个生产接口+多个具体产品类
 *      一个工厂类，用来生产商品
 *      一个客户端
 * 优点：将生产商品操作与客户端解耦，不用修改客户端
 */

//产品接口
interface Computer{
    void printComputer();
}
//具体类1
class MacBook implements Computer{

    @Override
    public void printComputer() {
        System.out.println("买一个MacBook");
    }
}
//具体类2
class Surface implements Computer{

    @Override
    public void printComputer() {
        System.out.println("买一个Surface");
    }
}

class ComputerFactor{
    /**
     * 根据客户端传入的电脑类型，来实例化对象
     * @param s  客户端想购买的电脑
     * @return
     */
    public static Computer getInstance(String s) {
        if (s.equals("MacBook")) {
            return new MacBook();
        } else if (s.equals("Surface")) {
            return new Surface();
        } else {
            throw new IllegalArgumentException("当前机型不存在");
        }
    }
}

class Client{
    public void buyComputer(Computer computer){
        computer.printComputer();
    }
}
public class SimpleFactoryPattern {
    public static void main(String[] args) {
        //有一个客户
        Client client =new Client();
        //确定要买的电脑名
        System.out.println("请输入您要选择的机型：");
        Scanner in = new Scanner(System.in);
        String computerName = in.nextLine();
        //根据电脑名用共产类生产一个电脑对象
        Computer computer = ComputerFactor.getInstance(computerName);
        //在客户端传入电脑对象调用买方法买电脑
        client.buyComputer(computer);


    }
}
