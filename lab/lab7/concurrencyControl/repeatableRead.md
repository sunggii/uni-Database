# Repeatable Read
- ข้อมูลที่ transaction อ่านครั้งแรก
- จะต้องเหมือนเดิมตลอด transaction

## Read Commit : Nonrepeatable Read Problem
- ทดลองทำตาม diagram นี้

![alt text](../img/repeat1.png)


### สรุปผลการทดลอง
- พบว่าเมื่อ insert ใน T1 จะทำให้ จำนวน row (count) เพิ่มขึ้นจาก 1 -> 2
- แต่ T2 ก็จะไม่เห็นการเปลี่ยนแปลงของ T1
- เมื่อ T1 อ่านข้อมูลซ้ำก็จะได้ (10, 1000) `เหมือนเดิมแม้ T2 จะ commit มาแล้วก็ตาม` 
    ```
     id | balance
    ----+---------
    10 |    1000
    11 |     111
    (2 rows)
    ```
- จึงสรุปว่า `Repeatable Read` แก้ปัญหา `Nonrepeatable Read` ได้จริง
- หลังจากที่ commit ทั้ง 2 ฝั่ง(จบ transactionทั้งคู่) ถึงจะเห็นข้อมูลที่แต่ละฝั่งได้ทำลงไป
    ```
    postgres=# Select * from accounts;
    id | balance
    ----+---------
    11 |     111  -> T1
    10 |      40  -> T2
    (2 rows)
    ```
