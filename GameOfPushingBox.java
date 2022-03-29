package game;

import java.util.Locale;
import java.util.Scanner;
/**
 * @Description
 * @Author:ZhangShuai
 * @CreateTime:2022/1/22 11:25
 **/
public class GameOfPushingBox {
    static{//静态区域块
        System.out.println("温馨提醒：‘&’为玩家所在位置，‘o’为箱子，‘*‘为终点");
        System.out.println("玩家可以推动箱子移动，箱子到达’*‘位置即为通关");
    }
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        //创建对象
        char[][] map = new char[8][10];
        //创建地图
        int x = 1, y = 1;
        //玩家初始位置
        boolean result = false;
        for (int i = 0; i < map.length; i++) {
            //创建地图外围墙壁
            if (i == 0 || i == 7) {
                for (int j = 0; j < map[i].length; j++) {
                    map[i][j] = '!';
                }
            } else {
                map[i][0] = '!';
                map[i][9] = '!';
            }
        }
        //地图内墙壁
        map[1][3] = '!';

        map[2][3] = '!';
        map[3][3] = '!';
        map[2][5] = '!';
        map[3][5] = '!';
        map[3][6] = '!';
        map[3][8] = '!';
        map[6][4]='!';
        map[5][4] = '!';
        map[5][5] = '!';
        map[5][6] = '!';
        map[7][4] = '!';
        //玩家所处的初始位置
        map[1][1] = '&';

        map[2][2] = 'o';
        //苹果所在的初始位置
        map[6][5] = '*';


        while (true) {
            //循环游戏
            System.out.println("---------------------------");
            for (char[] arr : map
                //打印游戏画面
            ) {
                for (char i : arr
                ) {
                    System.out.print(" " + i);

                }
                System.out.println();

            }
            System.out.println("-----------------------");

            if (result) {
                //游戏结束
                break;
            }
            System.out.println("w 上移；a 左移；s 下移；d 右移；esc 退出游戏");
            System.out.println("请输入：");
            String code = src.nextLine();
            //获取玩家指令
            switch (code.toLowerCase(Locale.ROOT)) {
                //将执行转为小写并判断
                case "a":
                    //如果输入的是a
                    if (map[x][y - 1] == 0) {
                        //如果玩家左边是空区
                        map[x][y] = 0;
                        //原位置变为空区
                        map[x][y - 1] = '&';
                        //玩家移动到新区域
                        y--;
                        //玩家坐标左移

                    } else if (map[x][y - 1] == 'o') {
                        //如果玩家左边是箱子
                        if (map[x][y - 2] != 'H') {
                            //如果箱子左边不是墙壁
                            if (map[x][y - 2] == '*') {
                                //如果箱子左边是目的地
                                result = true;
                                //游戏结束
                            }
                            map[x][y] = 0;
                            //原位置变为空区
                            map[x][y - 1] = '&';
                            //玩家移动到新位置
                            map[x][y - 2] = 'o';
                            //箱子移动到新位置
                            y--;
                            //玩家位置左移
                        }
                    }
                    break;//结束判断

                case "w":
                    //如果玩家输入w
                    if (map[x - 1][y] == 0) {
                        //如果玩家上边是空位
                        map[x][y] = 0;
                        //本来的位置变为空位
                        map[x - 1][y] = '&';
                        //玩家位置左移
                        x--;
                    } else if (map[x - 1][y] == 'o') {
                        //如果玩家上边为箱子
                        if (map[x - 2][y] != 'H') {
                            //如果箱子上边不为墙壁
                            if (map[x - 2][y] == '*') {
                                //如果箱子左边是目的地
                                result = true;
                                break;
                            }
                            map[x][y] = 0;
                            //原位置变为空区
                            map[x - 1][y] = '&';
                            //玩家移动到新位置
                            map[x - 2][y] = 'o';
                            //箱子移动到新的位置
                            x--;
                            //玩家位置左移
                        }
                    }
                    break;//判断结束

                case "s":
                    //如果玩家输入s
                    if (map[x + 1][y] == 0) {
                        //如果玩家下边是空位
                        map[x][y] = 0;
                        //玩家原位置变空
                        map[x + 1][y] = '&';
                        //玩家原位置下移
                        x++;
                    } else if (map[x + 1][y] == 'o') {
                        //如果玩家下边是箱子
                        if (map[x + 2][y] != 'H') {
                            //如果玩家下边不是墙壁
                            if (map[x + 2][y] == '*') {
                                //如果玩家下边是终点
                                result = true;
                                break;
                            }
                            map[x][y] = 0;
                            map[x + 1][y] = '&';
                            map[x + 2][y] = 'o';
                            x++;
                        }
                    }
                    break;


                case "d":
                    //玩家输入d
                    if (map[x][y + 1] == 0) {
                        //如果玩家右方不为墙壁
                        map[x][y] = 0;
                        map[x][y + 1] = '&';
                        y++;
                    } else if (map[x][y + 1] == 'o') {
                        if (map[x][y + 2] != 'H') {
                            if (map[x][y + 2] == '*') {
                                result = true;
                                break;
                            }
                            map[x][y] = 0;
                            map[x][y + 1] = '&';
                            map[x][y + 2] = 'o';
                            y++;
                        }
                    }
                    break;
                case "esc":
                    System.out.println("退出游戏");

                    break;
                default:
                    System.out.println("您输入的信息有误！请更改");
            }
        }
        if (result) {
            System.out.println("游戏结束，恭喜通关！");
        } else {
            System.out.println("游戏已退出");
        }
        src.close();
    }
}