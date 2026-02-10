# Basic Operations
| พีชคณิตเชิงสัมพันธ์   | สัญลักษณ์ | ความหมาย                                            | ตัวอย่างใน SQL                                   |
| --------------------- | --------- | --------------------------------------------------- | ------------------------------------------------ |
| **Select**            | σ         | เลือกแถว (tuple) ตามเงื่อนไข                        | `SELECT * FROM student WHERE age > 20;`          |
| **Project**           | ∏         | เลือกเฉพาะคอลัมน์ที่ต้องการ                         | `SELECT name, age FROM student;`                 |
| **Union**             | ∪         | รวมผลลัพธ์จาก 2 ตาราง (ไม่ซ้ำ)                      | `SELECT col FROM A UNION SELECT col FROM B;`     |
| **Set Difference**    | −         | แสดงข้อมูลที่อยู่ในตารางแรก แต่ไม่อยู่ในตารางที่สอง | `SELECT col FROM A EXCEPT SELECT col FROM B;`    |
| **Cartesian Product** | ×         | จับคู่ทุกแถวของตารางหนึ่งกับทุกแถวของอีกตาราง       | `SELECT * FROM A CROSS JOIN B;`                  |
| **Rename**            | ρ         | เปลี่ยนชื่อตารางหรือคอลัมน์                         | `SELECT name AS student_name FROM student;`      |
| **Intersection**      | ∩         | แสดงข้อมูลที่อยู่เหมือนกันทั้งสองตาราง              | `SELECT col FROM A INTERSECT SELECT col FROM B;` |
| **Join**            | ⨝         | เชื่อมตารางตั้งแต่ 2 ตารางขึ้นไปตามเงื่อนไข | `SELECT * FROM student s JOIN dept d ON s.majorid = d.did;` |


## ใน lab นี้เราทำอะไร
- ได้ลองใช้คำสั่ง Basic op
- โดยจะแบ่งเป็น 2 part
    - part อ.อภิรักษ์ 
    - part อ.กฤษ ใน part นี้จะมีการทำ ```exercise``` ด้วย

## ใน part อ.กฤษ
- ได้มีการ setup postgres ใหม่ สามารถทำตาม [doc จารย์: ](https://luckkrit.github.io/cos3103/slides/2_68/sql_dml/) ได้
    - [link load postgres ](https://www.enterprisedb.com/downloads/postgres-postgresql-downloads)
    
- นับจาก lab 2 นี้ จะใช้ ```classicmodels``` ในการเรียน Query

