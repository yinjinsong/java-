package hash;

import java.util.Scanner;

public class HashDemo {
    public static void main(String[] args) {

        HashTable hashTable = new HashTable(7);
        Scanner scanner = new Scanner(System.in);
        String line = "";
        while (true) {
            System.out.println("add: 添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("del: 删除雇员");
            System.out.println("exit: 退出");
            line = scanner.next();
            switch (line) {
                case "add":
                    System.out.println("请输入雇员的id");
                    int id = scanner.nextInt();
                    System.out.println("请输入雇员的姓名");
                    String name = scanner.next();
                    Empy empy = new Empy(id, name);
                    hashTable.add(empy);
                    break;
                case "list":
                    hashTable.list();
                    break;
                case "find":
                    System.out.println("请输入需要查找的id");
                    int id1 = scanner.nextInt();
                    hashTable.findById(id1);
                    break;
                case "del":
                    System.out.println("请输入需要删除的id");
                    int i = scanner.nextInt();
                    hashTable.delete(i);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("输入值非法！");
                    break;
            }
        }
    }
}

class HashTable {
    private EmpyLinkedList[] empyLinkedLists;
    private int size;

    public HashTable(int size) {
        this.size = size;
        //给定hash数组初始化大小
        empyLinkedLists = new EmpyLinkedList[size];
        //初始化每一个数组的链表
        for (int i = 0; i < size; i++) {
            empyLinkedLists[i] = new EmpyLinkedList();
        }
    }

    /**
     * 取hash值
     * @param id
     * @return
     */
    public int getHash(int id) {
        return id % size;
    }

    /**
     * 新增雇员
     * 先找到对应的数组是第几个，然后在链表上添加
     * @param empy
     */
    public void add(Empy empy) {
        int no = getHash(empy.getId());
        empyLinkedLists[no].add(empy);
    }

    /**
     * 根据指定id删除雇员
     * @param id
     */
    public void delete(int id) {
        int hash = getHash(id);
        empyLinkedLists[hash].delete(id);
    }
    /**
     * 打印hashtable
     */
    public void list() {
        for (int i = 0; i < size; i++) {
            empyLinkedLists[i].list(i);
        }
    }

    /**
     * 根据id查找雇员
     * @param id
     * @return
     */
    public Empy findById(int id) {
        int hash = getHash(id);
        Empy empy = empyLinkedLists[hash].findById(id);
        if (empy == null) {
            System.out.println("未找到");
            return null;
        }
        System.out.printf("在第%d条链表中找到 雇员 id = %d\n", (hash + 1), id);
        return empy;
    }
}

class EmpyLinkedList {
    private Empy head;

    /**
     * 新增雇员
     * @param empy
     */
    public void add(Empy empy) {
        if (head == null) {
            head = empy;
        } else {
            Empy curEmpy = head;
            while (curEmpy.next != null) {
                curEmpy = curEmpy.next;
            }
            curEmpy.next = empy;
        }

    }

    /**
     * 根据指定id删除雇员
     * @param id
     */
    public void delete(int id) {
        if (id < 0) {
            System.out.println("编号非法！");
            return;
        }
        Empy curEmpy = head;
        if (curEmpy == null) {
            System.out.println("当前链表为空");
            return;
        }

        //如果头结点是待删除结点
        if (curEmpy.getId() == id) {
            head = curEmpy.next;
            return;
        }

        while (curEmpy.next != null) {
            if (curEmpy.next.getId() == id) {
                Empy next = curEmpy.next.next;
                curEmpy.next = next;
                return;
            }
            curEmpy = curEmpy.next;

        }
        System.out.println("未找到指定编号的雇员");

    }

    /**
     * 显示当前雇员链表
     */
    public void list(int no) {
        if (head == null) {
            System.out.println("第" + (no + 1) + "条链表为空");
            return;
        }
        System.out.println("第" + (no + 1) + "条链表的信息为:");
        Empy curEmpy = head;
        while (curEmpy != null) {
            System.out.printf("=>id=%d,name=%s\t", curEmpy.getId(), curEmpy.getName());
            curEmpy = curEmpy.next;
        }
        System.out.println();
    }


    /**
     * 根据id查找雇员
     * @param id
     * @return
     */
    public Empy findById(int id) {
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }
        Empy curEmpy = head;
        while (curEmpy != null) {
            if (curEmpy.getId() == id) {
                return curEmpy;
            }
            curEmpy = curEmpy.next;
        }
        return null;
    }


}
class Empy {

    //data域
    public int id;
    public String name;
    //next域
    public Empy next;


    public Empy(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Empy(Empy empy) {
        this.id = empy.id;
        this.name = empy.name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
