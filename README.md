# COS3103: Database Systems - SQL Learning Labs

หลักสูตรห้องปฏิบัติการแบบครอบคลุมที่ครอบคลุมพื้นฐาน SQL และแนวคิดฐานข้อมูลผ่านการฝึกปฏิบัติจริง

## 👩‍💻Course Content

**Lab 1: Referential Integrity Constraints**

- เรียนรู้ข้อจำกัดคีย์ต่างประเทศ 3 ประเภท: NO ACTION, SET NULL และ CASCADE
- ทำความเข้าใจการคงความสัมพันธ์ของข้อมูลและการบังคับใช้ความสมบูรณ์เชิงอ้างอิงในฐานข้อมูลเชิงสัมพันธ์

**Lab 2: Basic SQL Operations**

- เชี่ยวชาญการปฏิบัติการ SQL พื้นฐาน เช่น SELECT, PROJECT, UNION, INTERSECTION และ JOIN
- ทำงานกับฐานข้อมูล ClassicModels เพื่อฝึกการสืบค้นและการจัดการข้อมูล

**Lab 3: Basic SQL Operations (Continuation)**

- สำรวจ JOIN หลายประเภท (INNER, LEFT, RIGHT, NATURAL, SELF JOIN)
- เรียนรู้คำสั่งเพิ่มเติม เช่น GROUP BY, HAVING และ ORDER BY
- ใช้ Jupyter Notebook เพื่อรันคำสั่ง SQL แบบโต้ตอบ
- เชี่ยวชาญการสรุปข้อมูลและคิวรีที่ซับซ้อน

**Lab 4: Advanced SQL Operations**

- เรียนรู้การเขียน Subquery แบบ Single-row และ Multiple-row
- ใช้ Subquery ร่วมกับ `WHERE`, `HAVING`, `FROM`, `IN`, `NOT IN`, `ANY` และ `ALL`
- ประยุกต์ใช้ Aggregate Functions และ Correlated Subquery

**Lab 5: Database Application Connectivity**

- ทดลองสร้างโปรเจกต์ด้วย Java, Maven และ Spring Initializr
- เรียนรู้การเชื่อมต่อ PostgreSQL จาก Java ด้วย JDBC
- ใช้งาน `Connection`, `Statement`, `PreparedStatement`, `ResultSet` และ `CallableStatement`
- เรียกใช้ Function และ Stored Procedure จากโปรแกรมภายนอก

**Lab 6: Views, Stored Procedures, Functions และ Cursor**

- สร้างและใช้งาน View เพื่อจัดการ Query ที่ใช้ซ้ำ
- เขียน Anonymous Block และ Stored Procedure ด้วย PL/pgSQL
- ใช้ตัวแปร เงื่อนไข และลูปในการเขียนโปรแกรมภายในฐานข้อมูล
- เปรียบเทียบ Procedure กับ Function และเรียนรู้การใช้ Cursor
- ประยุกต์ใช้ Logic ของฐานข้อมูลร่วมกับโปรเจกต์ Java

**Lab 7: Transaction และ Concurrency Control**

- เรียนรู้แนวคิด Transaction และการใช้ `COMMIT` กับ `ROLLBACK`
- ศึกษาปัญหาจากการทำงานพร้อมกัน เช่น Lost Update, Dirty Read, Non-repeatable Read และ Phantom Read
- เรียนรู้ Isolation Level ได้แก่ Read Committed, Repeatable Read และ Serializable
- ทดลองใช้ Locking Method, Shared Lock และ Exclusive Lock เพื่อควบคุมการเข้าถึงข้อมูล
- เปรียบเทียบความปลอดภัย ประสิทธิภาพ และความเสี่ยง Deadlock ของแต่ละ Isolation Level

## 🧱 Structure

- `exercise/` -> เก็บไฟล์แบบฝึกหัด
- `img/` -> เก็บภาพผลลัพธ์จากตัวอย่างของไฟล์ .md
- `workshop/`  -> เก็บตัวอย่าง workshop ที่ทำ

```
cos3103/
├─ lab/
|   ├─lab1/
|   ├─lab2/
|       ├─exercise/
|       ├─img/
|   ├─lab3/
|       ├─exercise/
|       ├─img/
|   ├─lab4/
|       ├─exercise/
|       ├─img/
|   ├─lab5/
|       ├─java_mvn/
|       ├─start_sping/
|       ├─img/
|   ├─lab6/
|       ├─workshop
|              ├─demo/
|       ├─img/
|   ├─lab7/
|       ├─concurrencyControl
|       ├─img/
└─ README.md
```

## 📌Key Features

- แบบฝึกหัดลงมือทำกับฐานข้อมูล ClassicModels
- การบูรณาการ Jupyter Notebook เพื่อการเรียนรู้
- ไฟล์สคริปต์ SQL สำหรับตั้งค่าฐานข้อมูลอย่างรวดเร็ว
- เอกสาร Markdown ที่ครบถ้วนพร้อมตัวอย่าง

## Technologies Used

- PostgreSQL
- SQL
- Jupyter Notebook (Python พร้อม SQL Magic)
- Python 3.13
