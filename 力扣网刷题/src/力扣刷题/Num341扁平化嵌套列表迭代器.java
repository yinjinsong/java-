package 力扣刷题;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Num341扁平化嵌套列表迭代器 {
    public class NestedIterator implements Iterator<Integer> {
        //存储最终结果
        private List<Integer> ans = new ArrayList<>();
        //当前pos
        private int cnt = 0;
//        public NestedIterator(List<NestedInteger> nestedList) {
//            dfs(nestedList);
//        }
//        //遍历当前列表，如果是数字就直接添加，如果是链表则递归进入链表dfs
//        private void dfs(List<NestedInteger> nestedList) {
//            for (NestedInteger nestedInteger : nestedList) {
//                if (nestedInteger.isInteger()) {
//                    ans.add(nestedInteger.getInteger());
//                } else {
//                    dfs(nestedInteger.getList());
//                }
//            }
//        }

        @Override
        public Integer next() {
            return ans.get(cnt++);
        }

        @Override
        public boolean hasNext() {
            return cnt < ans.size();
        }
    }
}
