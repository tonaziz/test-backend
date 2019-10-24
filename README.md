# test-backend

1.(dilihat dari gambar di file Data Dan Intruksi No1.png )

2.Data yang dikirm diamankan dengan bantuan keyloack karna terkesan aman dan sederhana serta restAPI yang disedakan cukup lengkap dari segi frontend maupun backend.

3.Tools yang diperlukan :
－Java 8
－Postman
－Postgresql dan pg Admin

Instalasi database :
－Buka aplikasi pgAdmin
－Create Server dengan ketentuan sebagai berikut :

spring.datasource.url=jdbc:postgresql://localhost:5432/apiary-proxy
spring.datasource.username=postgres 
spring.datasource.password=admin
spring.datasource.platform=postgresql

－Buat database dengan nama apiary-proxy
－Restore file apiary-proxy.sql



Cara penggunaan program:
－Untuk menjaankan buka cmd pada directory tempat anda mendownload test-program.jar
－Pada cmd ketikkan “java -jar test-program.jar”
－Buka postman dan jalankan url dengan port localhost:1313/
－Masukkan Authorization dengan value “eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoyLCJleHAiOjE1MTU4MzY0OTZ9.D6x6kcwcM2Cq6A5i-RVqBbyDxao-F2ln1TuGBmQu4LQ” serta kebutuhan lainnya seperti gambar di postman

Untuk mempermudah import file “Backend.postman_collection.json” ke dalam postman

4.Kekurangan dari restAPI :

－Pada create user harusnya ditambah dengan field “password confirm” yang bisasanya digunakan untuk mencocokan terlebih dahulu sebelum data dimasukkan
－Pada bagian crud parameter id yang digunakan seharunya bertipe data uuid agar tidak mudah di brute force , dan mudah terbaca
－Pada bagian crud dan database ditambahkan create_by dan updated_by agar mudah terlacak siapa user yang menambah atau mengubah data.
