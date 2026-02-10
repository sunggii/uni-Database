# Basic Operations(ต่อ)
- เนื้อหาจะต่อจาก lab 2 โดยหัวข้อที่ได้เรียนใน lab 3 คือ
    - join
    - clause อื่นๆที่ต่อจาก where clause
    ![alt text](./img/clause.png)
# ใน lab นี้เราทำอะไร
- ได้ลองใช้ jupyter ในการ query
- เรียน Basic Operations ต่อจาก lab 2 
    📌 [slide อาจารย์](https://luckkrit.github.io/cos3103/slides/2_68/sql_dml)

## วิธีใช้ jupyter ในการ query
### run รอบเดียวเพื่อติดตั้งแพ็กเกจ
```sql
%pip install jupysql psycopg2-binary 
```
### code ที่ต้องมีเพื่อให้ใช้งาน jupyter ได้
-  Load SQL extension

    ```sql
    %load_ext sql
    %config SqlMagic.displaylimit = 300 #กำหนด row ที่จะแสดง
    ```

- เชื่อมต่อ postgresql
    ```sql
    %sql postgresql://postgres:12345678@localhost:5432/postgres 
    ```

- ดูว่าใช้งานได้ไหม
    ```sql
    %sql SELECT version() #ลองเช็ค version 
    ```

### ทดลอง run
```sql
%sql SET search_path TO classicmodels, public
```

```sql
%%sql
select * from orders  #ถ้าถูกจะได้ผลลัพธ์
```