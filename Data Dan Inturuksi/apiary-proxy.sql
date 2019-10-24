PGDMP     &    #            	    w            apiary-proxy    10.5    10.5     �
           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            �
           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            �
           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            �
           1262    35864    apiary-proxy    DATABASE     �   CREATE DATABASE "apiary-proxy" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_United States.1252' LC_CTYPE = 'English_United States.1252';
    DROP DATABASE "apiary-proxy";
             postgres    false                        2615    35874 	   parameter    SCHEMA        CREATE SCHEMA parameter;
    DROP SCHEMA parameter;
             postgres    false                        2615    35865    product    SCHEMA        CREATE SCHEMA product;
    DROP SCHEMA product;
             postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false            �
           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    3                        3079    12924    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false                        0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    1            �            1259    35877 
   error_code    TABLE     1  CREATE TABLE parameter.error_code (
    id bigint NOT NULL,
    error_code character varying(5),
    error_name character varying(50),
    error_message character varying(200),
    created_at timestamp with time zone,
    created_by bigint,
    update_at timestamp with time zone,
    update_by bigint
);
 !   DROP TABLE parameter.error_code;
    	   parameter         postgres    false    6            �            1259    35875    error_code_id_seq    SEQUENCE     }   CREATE SEQUENCE parameter.error_code_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE parameter.error_code_id_seq;
    	   parameter       postgres    false    201    6                       0    0    error_code_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE parameter.error_code_id_seq OWNED BY parameter.error_code.id;
         	   parameter       postgres    false    200            �            1259    35868    products    TABLE     �   CREATE TABLE product.products (
    id bigint NOT NULL,
    name character varying(50),
    price bigint,
    imageurl character varying(255),
    created_at timestamp with time zone,
    updated_at timestamp with time zone
);
    DROP TABLE product.products;
       product         postgres    false    5            �            1259    35866    products_id_seq    SEQUENCE     y   CREATE SEQUENCE product.products_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE product.products_id_seq;
       product       postgres    false    5    199                       0    0    products_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE product.products_id_seq OWNED BY product.products.id;
            product       postgres    false    198            w
           2604    35880    error_code id    DEFAULT     t   ALTER TABLE ONLY parameter.error_code ALTER COLUMN id SET DEFAULT nextval('parameter.error_code_id_seq'::regclass);
 ?   ALTER TABLE parameter.error_code ALTER COLUMN id DROP DEFAULT;
    	   parameter       postgres    false    201    200    201            v
           2604    35871    products id    DEFAULT     l   ALTER TABLE ONLY product.products ALTER COLUMN id SET DEFAULT nextval('product.products_id_seq'::regclass);
 ;   ALTER TABLE product.products ALTER COLUMN id DROP DEFAULT;
       product       postgres    false    198    199    199            �
          0    35877 
   error_code 
   TABLE DATA               �   COPY parameter.error_code (id, error_code, error_name, error_message, created_at, created_by, update_at, update_by) FROM stdin;
 	   parameter       postgres    false    201   �       �
          0    35868    products 
   TABLE DATA               V   COPY product.products (id, name, price, imageurl, created_at, updated_at) FROM stdin;
    product       postgres    false    199                     0    0    error_code_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('parameter.error_code_id_seq', 3, true);
         	   parameter       postgres    false    200                       0    0    products_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('product.products_id_seq', 8, true);
            product       postgres    false    198            {
           2606    35882    error_code error_code_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY parameter.error_code
    ADD CONSTRAINT error_code_pkey PRIMARY KEY (id);
 G   ALTER TABLE ONLY parameter.error_code DROP CONSTRAINT error_code_pkey;
    	   parameter         postgres    false    201            y
           2606    35873    products products_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY product.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (id);
 A   ALTER TABLE ONLY product.products DROP CONSTRAINT products_pkey;
       product         postgres    false    199            �
   o   x�3�410�t�5000�tJLQJ-,M-.�420��54�52V04�20�26�321253�60�4 $�e4�j��g^YbNf����#9٘�\�Լ�������� >�8|      �
   �   x���M
�0��ur��I&�i��E(AKUlL�����\v;/_�r:��4�y��}32�f�i�%(��]wb�Y��C��1^�ܥA-wޢQ˓��,O�gF��@W�
�@��Z#5~�����j2�r�x��>e_�7��P �������~U����]��     