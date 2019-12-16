package com.example.blog.Service;

import java.util.ArrayList;
import java.util.List;

public class PageNmber {
    private List<Integer> list = new ArrayList<Integer>();
    public List<Integer> page(int page,int total){
        //如果总页数小于分页条的个数
        if(total<=5){
            for(int i=1;i<=total;i++)
            {
                list.add(i);
            }
            return list;
        }
        else {
            if(page<=2){
                for(int i=1;i<=5;i++)
                {
                    list.add(i);
                }
                return list;
            }
            if(page==total){
                for(int i=page-4;i<=total;i++)
                {
                    list.add(i);
                }
                return list;
            }
            if(page+2>total){
                for(int i=page-3;i<=total;i++){
                    list.add(i);
                }
                return list;
            }
            for(int i=page-2;i<=page+2;i++)
            {
                list.add(i);
            }
            return list;
        }
    }
}
