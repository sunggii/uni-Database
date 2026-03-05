# Read Committed
- Transaction จะ อ่านได้เฉพาะข้อมูลที่ COMMIT แล้วเท่านั้น
- ไม่เห็นข้อมูลที่ยังไม่ commit
- จึง ป้องกัน Dirty Read

## Read Commit : Solve Dirty read Problem
- ทดลองทำตาม diagram นี้

![alt text](/lab7/img/read1.png)

### สรุปผลการทดลอง
- พบว่าแก้ปัญหา Dirty read ได้จริง T1, T2 จะไม่เห้นข้อมูลการเปลี่ยนแปลงถ้าอีกผ่ายยังไม่ commit
- จังหวะสุดท้ายที่ T1 `INSERT INTO accounts VALUES (20, 2000);` จะเกิด `Deadlock` 
- เพราะ T2 ก็ insert ไปเหมือนกันด้วย PK 20 เหมือนกัน แต่ยังไใ่ commit ทำให้ที่ T1 เกิด `Deadlock`
- หลังจาก T2 commit T1 ก็จะ insert ไม่ต้องอยู่ดีเพราะ PK ซ้ำ
    ```
    postgres=*# INSERT INTO accounts VALUES (20, 2000);
    ERROR:  duplicate key value violates unique constraint "accounts_pkey"
    DETAIL:  Key (id)=(20) already exists.
    ```

## Read Commit : Nonrepeatable Read Problem
- ทดลองทำตาม diagram นี้

![alt text](/lab7/img/read2.png)

### สรุปผลการทดลอง
- พบว่า `Read Commit` ไม่สามารถแก้ปัญหา `Nonrepeatable Read` ได้
- หลังจากที่ T2 commit ไปแล้ว
- T1 อ่านค่าซ้ำแต่กลับได้ข้อมูลใหม่ที่ T2 commit มา แทนที่จะอ่านได้ข้อมูลเดิม