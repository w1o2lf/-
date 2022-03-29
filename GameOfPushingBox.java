package game;

import java.util.Locale;
import java.util.Scanner;
/**
 * @Description
 * @Author:ZhangShuai
 * @CreateTime:2022/1/22 11:25
 **/
public class GameOfPushingBox {
    static{//��̬�����
        System.out.println("��ܰ���ѣ���&��Ϊ�������λ�ã���o��Ϊ���ӣ���*��Ϊ�յ�");
        System.out.println("��ҿ����ƶ������ƶ������ӵ��*��λ�ü�Ϊͨ��");
    }
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        //��������
        char[][] map = new char[8][10];
        //������ͼ
        int x = 1, y = 1;
        //��ҳ�ʼλ��
        boolean result = false;
        for (int i = 0; i < map.length; i++) {
            //������ͼ��Χǽ��
            if (i == 0 || i == 7) {
                for (int j = 0; j < map[i].length; j++) {
                    map[i][j] = '!';
                }
            } else {
                map[i][0] = '!';
                map[i][9] = '!';
            }
        }
        //��ͼ��ǽ��
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
        //��������ĳ�ʼλ��
        map[1][1] = '&';

        map[2][2] = 'o';
        //ƻ�����ڵĳ�ʼλ��
        map[6][5] = '*';


        while (true) {
            //ѭ����Ϸ
            System.out.println("---------------------------");
            for (char[] arr : map
                //��ӡ��Ϸ����
            ) {
                for (char i : arr
                ) {
                    System.out.print(" " + i);

                }
                System.out.println();

            }
            System.out.println("-----------------------");

            if (result) {
                //��Ϸ����
                break;
            }
            System.out.println("w ���ƣ�a ���ƣ�s ���ƣ�d ���ƣ�esc �˳���Ϸ");
            System.out.println("�����룺");
            String code = src.nextLine();
            //��ȡ���ָ��
            switch (code.toLowerCase(Locale.ROOT)) {
                //��ִ��תΪСд���ж�
                case "a":
                    //����������a
                    if (map[x][y - 1] == 0) {
                        //����������ǿ���
                        map[x][y] = 0;
                        //ԭλ�ñ�Ϊ����
                        map[x][y - 1] = '&';
                        //����ƶ���������
                        y--;
                        //�����������

                    } else if (map[x][y - 1] == 'o') {
                        //���������������
                        if (map[x][y - 2] != 'H') {
                            //���������߲���ǽ��
                            if (map[x][y - 2] == '*') {
                                //������������Ŀ�ĵ�
                                result = true;
                                //��Ϸ����
                            }
                            map[x][y] = 0;
                            //ԭλ�ñ�Ϊ����
                            map[x][y - 1] = '&';
                            //����ƶ�����λ��
                            map[x][y - 2] = 'o';
                            //�����ƶ�����λ��
                            y--;
                            //���λ������
                        }
                    }
                    break;//�����ж�

                case "w":
                    //����������w
                    if (map[x - 1][y] == 0) {
                        //�������ϱ��ǿ�λ
                        map[x][y] = 0;
                        //������λ�ñ�Ϊ��λ
                        map[x - 1][y] = '&';
                        //���λ������
                        x--;
                    } else if (map[x - 1][y] == 'o') {
                        //�������ϱ�Ϊ����
                        if (map[x - 2][y] != 'H') {
                            //��������ϱ߲�Ϊǽ��
                            if (map[x - 2][y] == '*') {
                                //������������Ŀ�ĵ�
                                result = true;
                                break;
                            }
                            map[x][y] = 0;
                            //ԭλ�ñ�Ϊ����
                            map[x - 1][y] = '&';
                            //����ƶ�����λ��
                            map[x - 2][y] = 'o';
                            //�����ƶ����µ�λ��
                            x--;
                            //���λ������
                        }
                    }
                    break;//�жϽ���

                case "s":
                    //����������s
                    if (map[x + 1][y] == 0) {
                        //�������±��ǿ�λ
                        map[x][y] = 0;
                        //���ԭλ�ñ��
                        map[x + 1][y] = '&';
                        //���ԭλ������
                        x++;
                    } else if (map[x + 1][y] == 'o') {
                        //�������±�������
                        if (map[x + 2][y] != 'H') {
                            //�������±߲���ǽ��
                            if (map[x + 2][y] == '*') {
                                //�������±����յ�
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
                    //�������d
                    if (map[x][y + 1] == 0) {
                        //�������ҷ���Ϊǽ��
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
                    System.out.println("�˳���Ϸ");

                    break;
                default:
                    System.out.println("���������Ϣ���������");
            }
        }
        if (result) {
            System.out.println("��Ϸ��������ϲͨ�أ�");
        } else {
            System.out.println("��Ϸ���˳�");
        }
        src.close();
    }
}