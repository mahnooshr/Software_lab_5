# Software_lab_5

پس از نصب برنامه `YourKit` باید پلاگین آن را به `intelliJ` اضافه کنیم. برای این کار گزینه `Profile from within the IDE` را انتخاب کرده و گزینه `intelliJ` را انتخاب می کنیم

![alt text](Assets/image.png)

![alt text](Assets/image-1.png)

همان طور که در تصویر زیر مشاهده می کنیم پلاگین `YourKit` اضافه شده است.

![alt text](Assets/image-2.png)

حال برنامه `JavaCup` را با پروفایلر اجرا می کنیم.

برنامه از ما سه ورودی می خواهد و پس از دادن این سه ورودی و اجرای توابع `temp` و `eval` نمودار فعالیت `CPU` و `Memory` در `YourKit` نمایش داده می شود و به شکل زیر می باشد.

![alt text](Assets/image-3.png)

همان طور که در تصویر بالا مشاهده می کنید، هم `CPU` و هم `Memory` در زمان `1m 55s` در نقطه پیک خود هستند. با بررسی دستوراتی که در این زمان در حال اجرا بودند متوجه شدیم که تابع `temp`، تابعی است که بیش ترین مصرف منابع را دارد. 

![alt text](Assets/image-4.png)

همچنین از درخت اجرای برنامه نیز می توانیم مشاهده کنیم که تابع `temp` بیش ترین زمان را به خود اختصاص داده است.

![alt text](Assets/image-5.png)


## بهبود پرفورمنس تابع `temp`


ابتدا ساختار اولیه این تابع را بررسی می کنیم:

```java
public static void temp() {
        ArrayList a = new ArrayList();
        for (int i = 0; i < 10000; i++)
        {
            for (int j = 0; j < 20000; j++) {
                a.add(i + j);
            }
        }
    }
```
مشاهده می شود که حدود 200 میلیون عدد صحیح تولید و در لیست ذخیره می شود که همین دلیل پرفورمنس پایین این تابع شده است.
همچنین `ArrayList` با هر عملیات `add` به صورت پویا رشد می کند که می تواند باعث مصرف بالای حافظه شود.
   
به منظور بهینه سازی پرفورمنس این تابع، اندازه `ArrayList` را از پیش مشخص می کنیم تا تغییر اندازه آرایه مینیمم شود و همچنین حلقه داخلی را موازی سازی می کنیم و کد زیر را با تابع قبلی جایگزین می کنیم:

````java
    public static void temp() {
        
        int totalIterations = 10000 * 20000;
        ArrayList<Integer> a = new ArrayList<>(totalIterations);
        
        IntStream.range(0, 10000).parallel().forEach(i -> {
            
            for (int j = 0; j < 20000; j++) {
                a.add(i + j);
            }
        });
    }
````
همچنین کتابخانه `IntStream`  را هم اضافه می کنیم:

````java
import java.util.stream.IntStream;
````


