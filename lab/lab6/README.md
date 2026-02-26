# Views, Stored Procedures

## ใน lab นี้เราทำอะไร
Lab 6 นี้โฟกัสเรื่องการเขียนโปรแกรมฝั่งฐานข้อมูลใน PostgreSQL ผ่าน 2 หัวข้อหลัก:
- **Views**: สร้างตารางเสมือนจากคำสั่ง `SELECT` เพื่อให้ query ซ้ำ ๆ ได้ง่ายขึ้น
- **Stored Procedures / Functions**: เขียน logic (เช่น loop, if-else, case) ไว้ใน database แล้วเรียกใช้งานซ้ำได้
- **workshop**: ได้ลองเอาโปรเจคที่ขึ้นไว้ใน lab5 มาเขียน `Views`, `Stored Procedures/ Functions`

## ผลลัพธ์การเรียนรู้
หลังจบ Lab นี้ควรทำได้:
- ออกแบบ View เพื่อทำ query ที่อ่านง่ายและนำกลับมาใช้ซ้ำ
- แยก business logic บางส่วนไปไว้ใน database ด้วย Procedure/Function
- ใช้ PL/pgSQL ควบคุมการทำงานแบบมีเงื่อนไขและ loop
- เลือกใช้ `Procedure` หรือ `Function` ให้เหมาะกับงาน (เน้นการทำงาน vs เน้นคืนค่า)

