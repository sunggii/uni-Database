# Concurrency Control
จำลองการทำ Isolation Level ที่ Transection level เท่านั้น

| Isolation Level      | ป้องกันปัญหาอะไรได้บ้าง                |
| -------------------- | -------------------------------------- |
| **Read Uncommitted** | แทบไม่ป้องกันอะไรเลย (Dirty Read ได้)  |
| **Read Committed**   | ❌ Dirty Read                           |
| **Repeatable Read**  | ❌ Dirty Read, ❌ Non-repeatable Read    |
| **Serializable**     | ❌ ทุกปัญหา (เหมือนรันทีละ transaction) |

**หมายเหตุ**
- เนื่องจาก PostgreSQL not support `read uncommited` จึงไม่ได้ทำใน lab นี้

## Setup ก่อนทำ lab
- เราจะจำลองเป็น user 2 คน กำลังใช้งานระบบฐานข้อมูล (T1, T2)
- ให้ทำตามขั้นตอนดังนี้

![alt text](/lab7/img/setup1.png)

![alt text](/lab7/img/setup2.png)

![alt text](/lab7/img/setup3.png)

![alt text](/lab7/img/setup4.png)

![alt text](/lab7/img/setup5.png)

- เมื่อกด save จะได้ user1 ให้ทำซ้ำเพื่อสร้าง user2
- จากนั้นให้ไปที่ `powershell` แล้ว run `psql -U user1 -d postgres`
- ใส่รหัสแล้ว enter (ตอนใส่จะมองไม่เห็นรหัส ไม่ต้องตกใจ)
- ถ้าทุกอย่างถูกต้องจะได้แบบนี้

![alt text](/lab7/img/setup6.png)

## หลังจาก setup เรียบร้อยให้สร้างข้อมูลเริ่มต้น
- step1: `SET search_path TO classicmodels;`
- step2:
    ```
    CREATE TABLE accounts (
        id INT PRIMARY KEY,
        balance INT
    );
    ```
- step3:
    ```
    INSERT INTO accounts VALUES (10, 1000);
    Select * from accounts;
    ```
- step4: ถ้าทุกอย่าถูกต้องเมื่อ `Select * from accounts;` จะเจอข้อมูลที่ insert ไป และ `\dt` ดูจะเจอตารางที่พึ่งสร้าง

![alt text](/lab7/img/setup7.png)

