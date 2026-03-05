# Transection & Concurrency Control

## Transection
การทำ Transaction คือการรวมคำสั่งหลายคำสั่งให้เป็นงานเดียวกัน เพื่อควบคุมความถูกต้องของข้อมูลในฐานข้อมูล

- `COMMIT` ใช้ยืนยันการเปลี่ยนแปลงทั้งหมดใน Transaction ให้บันทึกลงฐานข้อมูลจริง
- `ROLLBACK` ใช้ยกเลิกการเปลี่ยนแปลงทั้งหมดใน Transaction และย้อนกลับไปยังสถานะก่อนเริ่ม 

## Concurrency Control
Concurrency Control เกิดขึ้นมาเพื่อแก้ปัญหา Concurrent Problem โดยในบทนี้เราจะแก้ปีญหาด้วย `Isolation Level`
![alt text](/lab7/img/con1.png)

## Concurrent Problem คืออะไร?
คือปีญหาที่เกิดขึ้นเมื่อมี หลาย transaction ทำงานพร้อมกัน (concurrently) แล้วเข้าถึงข้อมูลเดียวกันในเวลาใกล้เคียงกัน ทำให้ข้อมูลผิดพลาดหรือไม่สอดคล้องกัน

## ส่งผลให้เกิปัญหาดังนี้
- Lost Update – ค่าโดนเขียนทับโดยไม่ตั้งใจ
- Dirty Read – อ่านข้อมูลที่ยังไม่ commit
- Non-repeatable Read – อ่านรอบแรกกับรอบสองได้ค่าต่างกัน
- Write Phantom – มี row ใหม่โผล่จาก insert
- Count Phantom – มี Count เพิ่มขึ้นมาแบบงงๆ
- Incorrect Summary	– SUM / AVG / COUNT ผิดเพราะ concurrent update

## Isolation Level คืออะไร?
Isolation Level คือระดับการแยกการทำงานของแต่ละ transaction
กำหนดว่า transaction หนึ่ง `มองเห็น` การเปลี่ยนแปลงของอีก transaction ได้มากแค่ไหน
อยู่ในหลักการ ACID (ตัว I = Isolation)

| Isolation Level      | ป้องกันปัญหาอะไรได้บ้าง                |
| -------------------- | -------------------------------------- |
| **Read Uncommitted** | แทบไม่ป้องกันอะไรเลย (Dirty Read ได้)  |
| **Read Committed**   | ❌ Dirty Read                           |
| **Repeatable Read**  | ❌ Dirty Read, ❌ Non-repeatable Read    |
| **Serializable**     | ❌ ทุกปัญหา (เหมือนรันทีละ transaction) |


## ใน lab นี้เราทำอะไร
- ศึกษาและทดลอง `Concurrency Control` ด้วยการตั้งค่า `Isolation Level` เพื่อดูผลของการทำงานของ 2 transaction พร้อมกัน
- ทดลองเคสของ `Read Committed` เพื่อสังเกตว่า
	- ป้องกัน `Dirty Read` ได้ (จะไม่เห็นข้อมูลที่อีก transaction ยังไม่ commit)
	- ยังแก้ปัญหา `Non-repeatable Read` ไม่ได้ (อ่านรอบหลังอาจเห็นค่าที่ถูก commit ใหม่)
	- พบกรณีชนกันระหว่างการ insert (เช่น key ซ้ำ) ระหว่าง transaction
- ทดลองเคสของ `Repeatable Read` เพื่อยืนยันว่า
	- ค่า/ข้อมูลที่อ่านครั้งแรกใน transaction เดิมจะคงเดิมเมื่ออ่านซ้ำ
	- แม้อีก transaction จะ commit ไปแล้ว ก็ยังอ่านได้เป็น snapshot เดิมจนกว่าจะจบ transaction
