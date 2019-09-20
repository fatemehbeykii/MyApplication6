package com.example.zahra.myapplication.model;

import android.content.Context;


import com.example.zahra.myapplication.R;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Fotoroos on 05/06/2018.
 */

public class Landscape {
    int id;
    String title;
    String address;
    String gruop;
    String description ;
    int  imageId;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    LinkedList <Integer> gallery = new LinkedList<>();

    public LinkedList<Integer> getGallery() {
        return gallery;
    }

    public void setGallery(LinkedList<Integer> gallery) {
        this.gallery = gallery;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getAddress() {
        return address;
    }

    public String getGruop() {
        return gruop;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setGruop(String gruop) {
        this.gruop = gruop;
    }

    public int getImageId() {
        return imageId;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public static ArrayList<Landscape> getData(){
        ArrayList<Landscape> list = new ArrayList<>();
        int []imageId = getImages();
        String [] title =getTitles();
        String [] address= getAddresses();
        String[] gruop = getGruops();
        for (int i=0;i<title.length;i++){
            Landscape landscape = new Landscape();
            LinkedList<Integer> linkList =new LinkedList();
            landscape.setTitle(title[i]);
            landscape.setAddress(address[i]);
            landscape.setGruop(gruop[i]);
            for (int j = 0; j < 5; j++) {
                if (j == 0)
                    landscape.setImageId(imageId[i*5+j]);
                else{
                    linkList.addLast(imageId[i*5+j]);
                }
            }
            landscape.setGallery(linkList);
            list.add(landscape);
        }
        return list;
    }
    public static int[] getImages() {
        int []image={
                 R.drawable.image_1_1,R.drawable.image_1_1_1,R.drawable.image_1_1_2,R.drawable.image_1_1_3,R.drawable.image_1_1_4
                ,R.drawable.image_1_2,R.drawable.image_1_2_1,R.drawable.image_1_2_2,R.drawable.image_1_2_3,R.drawable.image_1_2_4
                ,R.drawable.image_1_3,R.drawable.image_1_3_1,R.drawable.image_1_3_2,R.drawable.image_1_3_3,R.drawable.image_1_3_4
                ,R.drawable.image_1_4,R.drawable.image_1_4_1,R.drawable.image_1_4_2,R.drawable.image_1_4_3,R.drawable.image_1_4_4
                ,R.drawable.image_1_5,R.drawable.image_1_5_1,R.drawable.image_1_5_2,R.drawable.image_1_5_3,R.drawable.image_1_5_4
                ,R.drawable.image_2_1,R.drawable.image_2_1_1,R.drawable.image_2_1_2,R.drawable.image_2_1_3,R.drawable.image_2_1_4
                ,R.drawable.image_2_2,R.drawable.image_2_2_1,R.drawable.image_2_2_2,R.drawable.image_2_2_3,R.drawable.image_2_2_4
                ,R.drawable.image_2_3,R.drawable.image_2_3_1,R.drawable.image_2_3_2,R.drawable.image_2_3_3,R.drawable.image_2_3_4
                ,R.drawable.image_2_4,R.drawable.image_2_4_1,R.drawable.image_2_4_2,R.drawable.image_2_4_3,R.drawable.image_2_4_4
                ,R.drawable.image_3_1,R.drawable.image_3_1_1,R.drawable.image_3_1_2,R.drawable.image_3_1_3,R.drawable.image_3_1_4
                ,R.drawable.image_3_2,R.drawable.image_3_2_1,R.drawable.image_3_2_2,R.drawable.image_3_2_3,R.drawable.image_3_2_4
                ,R.drawable.image_3_3,R.drawable.image_3_3_1,R.drawable.image_3_3_2,R.drawable.image_3_3_3,R.drawable.image_3_3_4
                ,R.drawable.image_4_1,R.drawable.image_4_1_1,R.drawable.image_4_1_2,R.drawable.image_4_1_3,R.drawable.image_4_1_4
        };
        return image;
    }
    public static String [] getTitles() {
        String [] title={"ناهار خوران "
                ,"جنگل النگدره",
                "دریاچه توشن "," جهان نما",
                "آبشار کبود وال ","زیارتگاه خالد نبی",
                "امامزاده روشن آباد",
                "امامزاده نور","امامزاده عبدالله",
                "خانه امیر لطیفی"," خانه باقری","دیوار دفاعی گرگان","برج المان گرگان"};
        return title;
    }
    public static String[] getAddresses() {
        String [] address={"چهار کیلومتری جنوب شهر گرگان واقع شده است .",
                "در بلوار ناهارخوران گرگان قرار دارد.",
                "حاشیه جنوبی روستای توشن در النگدره واقع در ۵ کیلومتری جنوب شهرستان گرگان قرار دارد.",
                " در مناطق مرتفع جنوب شهرستان گرگان و جنوب شرقی شهرستان کردکوی، در رشته کوه های البرز قرار گرفته است." +
                " بخش مهم آن در حوزه شهرستان کردکوی و ناحیه شرقی آن در حوزه شهرستان گرگان قرار دارد.",
                "چهار کیلومتری جنوب شهرستان علی آباد کتول و در عمق دره ای از جنگل های انبوه قرار دارد.",
                "۹۰کیلومتری شهرستان گنبد کاووس و بر فراز قله کوه گوگجه داغ قرار دارد .",
                "در کنار جاده قدیم گرگان- کردکوی واقع شده است .",
                "در محله سرچشمه گرگان  واقع شده است .",
                " در قسمت انتهایی شمال شهر گرگان واقع شده است .",
                "در گرگان، ضلع شمالی مسجدجامع واقع شده است .",
                " در گرگان، محله سرچشمه واقع شده است .",
                "از ساحل کمش تپه در جنوب رود اترک و شمال بندر ترکمن نیز آغاز می شود اما هنوز انتهایی برای آن مشخص نشده است و طبق احتمالاتی که وجود دارد ممکن است" +
                        " انتهای این دیوار دفاعی در مصب رود گرگان، روستای خوجه لر، کوه های گلیداغ و یا قله کوه علی آباد قرار گرفته باشد.",
                " در میدان بسیج شهر گرگان واقع شده است ."

        };
        return address ;
    }
    public static String[] getGruops() {
        String []  gruop={"مکان تفریحی","مکان تفریحی","مکان تفریحی","مکان تفریحی","مکان تفریحی","مکان مذهبی","مکان مذهبی","مکان مذهبی","مکان مذهبی","مکان تاریخی","مکان تاریخی","مکان تاریخی ","نماد مدرن"};
        return gruop;
    }
}
