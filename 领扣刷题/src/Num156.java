import java.util.ArrayList;
import java.util.List;

/*
给出若干闭合区间，合并所有重叠的部分。

样例
样例1:

输入: [(1,3)]
输出: [(1,3)]
样例 2:

输入:  [(1,3),(2,6),(8,10),(15,18)]
输出: [(1,6),(8,10),(15,18)]
 */
public class Num156 {
    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(4, 9));
        intervals.add(new Interval(8, 10));
        List<Interval> merge = merge(intervals);
        for (Interval interval : merge) {
            System.out.println(interval);
        }
    }
    //1.先将集合内元素按照左边下标进行排序
    //2.判断[1,3],[2,4]前一个元素的右下标是否大于等于后一个元素左下标
    public static List<Interval> merge(List<Interval> intervals) {
//        Collections.sort(intervals, new Comparator<Interval>() {
//            @Override
//            public int compare(Interval o1, Interval o2) {
//                return o1.start - o2.start;
//            }
//        });
        //用labmda表达式更简洁
        intervals.sort((o1, o2) -> o1.start - o2.start);
        List<Interval> ans = new ArrayList<>();
        Interval last = null;
        for (Interval interval : intervals) {
            if (last == null || last.end < interval.start) {
                ans.add(interval);
                //last是一个指针指向ans中的当前对象，存放的是ans当前对象的地址
                //所以可以修改ans中的当前值
                last = interval;
            } else {
                last.end = Math.max(last.end, interval.end);
            }
        }
        return ans;
    }
}

class Interval {
    public int start, end;
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
