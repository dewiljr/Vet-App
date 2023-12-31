PGDMP  6                    {            vet-app    16.1    16.1 G    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16397    vet-app    DATABASE     }   CREATE DATABASE "vet-app" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Turkish_Turkey.1254';
    DROP DATABASE "vet-app";
                postgres    false            �            1259    17007    animals    TABLE     �  CREATE TABLE public.animals (
    date_of_birth date,
    animal_customer_id integer NOT NULL,
    animal_id bigint NOT NULL,
    animal_name character varying(250),
    breed character varying(250),
    colour character varying(250),
    species character varying(250),
    gender character varying(255),
    CONSTRAINT animals_gender_check CHECK (((gender)::text = ANY ((ARRAY['MALE'::character varying, 'FEMALE'::character varying])::text[])))
);
    DROP TABLE public.animals;
       public         heap    postgres    false            �            1259    17005    animals_animal_customer_id_seq    SEQUENCE     �   CREATE SEQUENCE public.animals_animal_customer_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 5   DROP SEQUENCE public.animals_animal_customer_id_seq;
       public          postgres    false    217            �           0    0    animals_animal_customer_id_seq    SEQUENCE OWNED BY     a   ALTER SEQUENCE public.animals_animal_customer_id_seq OWNED BY public.animals.animal_customer_id;
          public          postgres    false    215            �            1259    17006    animals_animal_id_seq    SEQUENCE     ~   CREATE SEQUENCE public.animals_animal_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.animals_animal_id_seq;
       public          postgres    false    217            �           0    0    animals_animal_id_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.animals_animal_id_seq OWNED BY public.animals.animal_id;
          public          postgres    false    216            �            1259    17020    appointments    TABLE     �   CREATE TABLE public.appointments (
    appointment_animal_id integer NOT NULL,
    appointment_doctor_id integer NOT NULL,
    appointment_id bigint NOT NULL,
    date timestamp(6) without time zone
);
     DROP TABLE public.appointments;
       public         heap    postgres    false            �            1259    17017 &   appointments_appointment_animal_id_seq    SEQUENCE     �   CREATE SEQUENCE public.appointments_appointment_animal_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 =   DROP SEQUENCE public.appointments_appointment_animal_id_seq;
       public          postgres    false    221            �           0    0 &   appointments_appointment_animal_id_seq    SEQUENCE OWNED BY     q   ALTER SEQUENCE public.appointments_appointment_animal_id_seq OWNED BY public.appointments.appointment_animal_id;
          public          postgres    false    218            �            1259    17018 &   appointments_appointment_doctor_id_seq    SEQUENCE     �   CREATE SEQUENCE public.appointments_appointment_doctor_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 =   DROP SEQUENCE public.appointments_appointment_doctor_id_seq;
       public          postgres    false    221            �           0    0 &   appointments_appointment_doctor_id_seq    SEQUENCE OWNED BY     q   ALTER SEQUENCE public.appointments_appointment_doctor_id_seq OWNED BY public.appointments.appointment_doctor_id;
          public          postgres    false    219            �            1259    17019    appointments_appointment_id_seq    SEQUENCE     �   CREATE SEQUENCE public.appointments_appointment_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 6   DROP SEQUENCE public.appointments_appointment_id_seq;
       public          postgres    false    221            �           0    0    appointments_appointment_id_seq    SEQUENCE OWNED BY     c   ALTER SEQUENCE public.appointments_appointment_id_seq OWNED BY public.appointments.appointment_id;
          public          postgres    false    220            �            1259    17030    available_dates    TABLE     �   CREATE TABLE public.available_dates (
    available_date date,
    available_doctor_id integer NOT NULL,
    available_id bigint NOT NULL
);
 #   DROP TABLE public.available_dates;
       public         heap    postgres    false            �            1259    17028 '   available_dates_available_doctor_id_seq    SEQUENCE     �   CREATE SEQUENCE public.available_dates_available_doctor_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 >   DROP SEQUENCE public.available_dates_available_doctor_id_seq;
       public          postgres    false    224                        0    0 '   available_dates_available_doctor_id_seq    SEQUENCE OWNED BY     s   ALTER SEQUENCE public.available_dates_available_doctor_id_seq OWNED BY public.available_dates.available_doctor_id;
          public          postgres    false    222            �            1259    17029     available_dates_available_id_seq    SEQUENCE     �   CREATE SEQUENCE public.available_dates_available_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 7   DROP SEQUENCE public.available_dates_available_id_seq;
       public          postgres    false    224                       0    0     available_dates_available_id_seq    SEQUENCE OWNED BY     e   ALTER SEQUENCE public.available_dates_available_id_seq OWNED BY public.available_dates.available_id;
          public          postgres    false    223            �            1259    17038 	   customers    TABLE       CREATE TABLE public.customers (
    customer_id bigint NOT NULL,
    customer_address character varying(250),
    customer_city character varying(250),
    customer_mail character varying(250),
    customer_name character varying(250),
    customer_phone character varying(250)
);
    DROP TABLE public.customers;
       public         heap    postgres    false            �            1259    17037    customers_customer_id_seq    SEQUENCE     �   CREATE SEQUENCE public.customers_customer_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.customers_customer_id_seq;
       public          postgres    false    226                       0    0    customers_customer_id_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.customers_customer_id_seq OWNED BY public.customers.customer_id;
          public          postgres    false    225            �            1259    17047    doctors    TABLE       CREATE TABLE public.doctors (
    doctor_id bigint NOT NULL,
    doctor_address character varying(250),
    doctor_city character varying(250),
    doctor_mail character varying(250),
    doctor_name character varying(250),
    doctor_phone character varying(250)
);
    DROP TABLE public.doctors;
       public         heap    postgres    false            �            1259    17046    doctors_doctor_id_seq    SEQUENCE     ~   CREATE SEQUENCE public.doctors_doctor_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.doctors_doctor_id_seq;
       public          postgres    false    228                       0    0    doctors_doctor_id_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.doctors_doctor_id_seq OWNED BY public.doctors.doctor_id;
          public          postgres    false    227            �            1259    17057    vaccines    TABLE     �   CREATE TABLE public.vaccines (
    finish_date date,
    start_date date,
    vaccine_animal_id integer NOT NULL,
    vaccine_id bigint NOT NULL,
    vaccine_code character varying(250),
    vaccine_name character varying(250)
);
    DROP TABLE public.vaccines;
       public         heap    postgres    false            �            1259    17055    vaccines_vaccine_animal_id_seq    SEQUENCE     �   CREATE SEQUENCE public.vaccines_vaccine_animal_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 5   DROP SEQUENCE public.vaccines_vaccine_animal_id_seq;
       public          postgres    false    231                       0    0    vaccines_vaccine_animal_id_seq    SEQUENCE OWNED BY     a   ALTER SEQUENCE public.vaccines_vaccine_animal_id_seq OWNED BY public.vaccines.vaccine_animal_id;
          public          postgres    false    229            �            1259    17056    vaccines_vaccine_id_seq    SEQUENCE     �   CREATE SEQUENCE public.vaccines_vaccine_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.vaccines_vaccine_id_seq;
       public          postgres    false    231                       0    0    vaccines_vaccine_id_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.vaccines_vaccine_id_seq OWNED BY public.vaccines.vaccine_id;
          public          postgres    false    230            8           2604    17010    animals animal_customer_id    DEFAULT     �   ALTER TABLE ONLY public.animals ALTER COLUMN animal_customer_id SET DEFAULT nextval('public.animals_animal_customer_id_seq'::regclass);
 I   ALTER TABLE public.animals ALTER COLUMN animal_customer_id DROP DEFAULT;
       public          postgres    false    217    215    217            9           2604    17011    animals animal_id    DEFAULT     v   ALTER TABLE ONLY public.animals ALTER COLUMN animal_id SET DEFAULT nextval('public.animals_animal_id_seq'::regclass);
 @   ALTER TABLE public.animals ALTER COLUMN animal_id DROP DEFAULT;
       public          postgres    false    216    217    217            :           2604    17023 "   appointments appointment_animal_id    DEFAULT     �   ALTER TABLE ONLY public.appointments ALTER COLUMN appointment_animal_id SET DEFAULT nextval('public.appointments_appointment_animal_id_seq'::regclass);
 Q   ALTER TABLE public.appointments ALTER COLUMN appointment_animal_id DROP DEFAULT;
       public          postgres    false    218    221    221            ;           2604    17024 "   appointments appointment_doctor_id    DEFAULT     �   ALTER TABLE ONLY public.appointments ALTER COLUMN appointment_doctor_id SET DEFAULT nextval('public.appointments_appointment_doctor_id_seq'::regclass);
 Q   ALTER TABLE public.appointments ALTER COLUMN appointment_doctor_id DROP DEFAULT;
       public          postgres    false    221    219    221            <           2604    17025    appointments appointment_id    DEFAULT     �   ALTER TABLE ONLY public.appointments ALTER COLUMN appointment_id SET DEFAULT nextval('public.appointments_appointment_id_seq'::regclass);
 J   ALTER TABLE public.appointments ALTER COLUMN appointment_id DROP DEFAULT;
       public          postgres    false    221    220    221            =           2604    17033 #   available_dates available_doctor_id    DEFAULT     �   ALTER TABLE ONLY public.available_dates ALTER COLUMN available_doctor_id SET DEFAULT nextval('public.available_dates_available_doctor_id_seq'::regclass);
 R   ALTER TABLE public.available_dates ALTER COLUMN available_doctor_id DROP DEFAULT;
       public          postgres    false    222    224    224            >           2604    17034    available_dates available_id    DEFAULT     �   ALTER TABLE ONLY public.available_dates ALTER COLUMN available_id SET DEFAULT nextval('public.available_dates_available_id_seq'::regclass);
 K   ALTER TABLE public.available_dates ALTER COLUMN available_id DROP DEFAULT;
       public          postgres    false    224    223    224            ?           2604    17041    customers customer_id    DEFAULT     ~   ALTER TABLE ONLY public.customers ALTER COLUMN customer_id SET DEFAULT nextval('public.customers_customer_id_seq'::regclass);
 D   ALTER TABLE public.customers ALTER COLUMN customer_id DROP DEFAULT;
       public          postgres    false    226    225    226            @           2604    17050    doctors doctor_id    DEFAULT     v   ALTER TABLE ONLY public.doctors ALTER COLUMN doctor_id SET DEFAULT nextval('public.doctors_doctor_id_seq'::regclass);
 @   ALTER TABLE public.doctors ALTER COLUMN doctor_id DROP DEFAULT;
       public          postgres    false    227    228    228            A           2604    17060    vaccines vaccine_animal_id    DEFAULT     �   ALTER TABLE ONLY public.vaccines ALTER COLUMN vaccine_animal_id SET DEFAULT nextval('public.vaccines_vaccine_animal_id_seq'::regclass);
 I   ALTER TABLE public.vaccines ALTER COLUMN vaccine_animal_id DROP DEFAULT;
       public          postgres    false    231    229    231            B           2604    17061    vaccines vaccine_id    DEFAULT     z   ALTER TABLE ONLY public.vaccines ALTER COLUMN vaccine_id SET DEFAULT nextval('public.vaccines_vaccine_id_seq'::regclass);
 B   ALTER TABLE public.vaccines ALTER COLUMN vaccine_id DROP DEFAULT;
       public          postgres    false    230    231    231            �          0    17007    animals 
   TABLE DATA           |   COPY public.animals (date_of_birth, animal_customer_id, animal_id, animal_name, breed, colour, species, gender) FROM stdin;
    public          postgres    false    217   `X       �          0    17020    appointments 
   TABLE DATA           j   COPY public.appointments (appointment_animal_id, appointment_doctor_id, appointment_id, date) FROM stdin;
    public          postgres    false    221   Y       �          0    17030    available_dates 
   TABLE DATA           \   COPY public.available_dates (available_date, available_doctor_id, available_id) FROM stdin;
    public          postgres    false    224   ;Y       �          0    17038 	   customers 
   TABLE DATA              COPY public.customers (customer_id, customer_address, customer_city, customer_mail, customer_name, customer_phone) FROM stdin;
    public          postgres    false    226   �Y       �          0    17047    doctors 
   TABLE DATA           q   COPY public.doctors (doctor_id, doctor_address, doctor_city, doctor_mail, doctor_name, doctor_phone) FROM stdin;
    public          postgres    false    228   �[       �          0    17057    vaccines 
   TABLE DATA           v   COPY public.vaccines (finish_date, start_date, vaccine_animal_id, vaccine_id, vaccine_code, vaccine_name) FROM stdin;
    public          postgres    false    231   �\                  0    0    animals_animal_customer_id_seq    SEQUENCE SET     M   SELECT pg_catalog.setval('public.animals_animal_customer_id_seq', 1, false);
          public          postgres    false    215                       0    0    animals_animal_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.animals_animal_id_seq', 1, false);
          public          postgres    false    216                       0    0 &   appointments_appointment_animal_id_seq    SEQUENCE SET     T   SELECT pg_catalog.setval('public.appointments_appointment_animal_id_seq', 6, true);
          public          postgres    false    218            	           0    0 &   appointments_appointment_doctor_id_seq    SEQUENCE SET     T   SELECT pg_catalog.setval('public.appointments_appointment_doctor_id_seq', 6, true);
          public          postgres    false    219            
           0    0    appointments_appointment_id_seq    SEQUENCE SET     M   SELECT pg_catalog.setval('public.appointments_appointment_id_seq', 6, true);
          public          postgres    false    220                       0    0 '   available_dates_available_doctor_id_seq    SEQUENCE SET     V   SELECT pg_catalog.setval('public.available_dates_available_doctor_id_seq', 1, false);
          public          postgres    false    222                       0    0     available_dates_available_id_seq    SEQUENCE SET     O   SELECT pg_catalog.setval('public.available_dates_available_id_seq', 1, false);
          public          postgres    false    223                       0    0    customers_customer_id_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.customers_customer_id_seq', 1, false);
          public          postgres    false    225                       0    0    doctors_doctor_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.doctors_doctor_id_seq', 1, false);
          public          postgres    false    227                       0    0    vaccines_vaccine_animal_id_seq    SEQUENCE SET     M   SELECT pg_catalog.setval('public.vaccines_vaccine_animal_id_seq', 1, false);
          public          postgres    false    229                       0    0    vaccines_vaccine_id_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.vaccines_vaccine_id_seq', 1, false);
          public          postgres    false    230            E           2606    17016    animals animals_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.animals
    ADD CONSTRAINT animals_pkey PRIMARY KEY (animal_id);
 >   ALTER TABLE ONLY public.animals DROP CONSTRAINT animals_pkey;
       public            postgres    false    217            G           2606    17027    appointments appointments_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.appointments
    ADD CONSTRAINT appointments_pkey PRIMARY KEY (appointment_id);
 H   ALTER TABLE ONLY public.appointments DROP CONSTRAINT appointments_pkey;
       public            postgres    false    221            I           2606    17036 $   available_dates available_dates_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY public.available_dates
    ADD CONSTRAINT available_dates_pkey PRIMARY KEY (available_id);
 N   ALTER TABLE ONLY public.available_dates DROP CONSTRAINT available_dates_pkey;
       public            postgres    false    224            K           2606    17045    customers customers_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public.customers
    ADD CONSTRAINT customers_pkey PRIMARY KEY (customer_id);
 B   ALTER TABLE ONLY public.customers DROP CONSTRAINT customers_pkey;
       public            postgres    false    226            M           2606    17054    doctors doctors_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.doctors
    ADD CONSTRAINT doctors_pkey PRIMARY KEY (doctor_id);
 >   ALTER TABLE ONLY public.doctors DROP CONSTRAINT doctors_pkey;
       public            postgres    false    228            O           2606    17065    vaccines vaccines_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.vaccines
    ADD CONSTRAINT vaccines_pkey PRIMARY KEY (vaccine_id);
 @   ALTER TABLE ONLY public.vaccines DROP CONSTRAINT vaccines_pkey;
       public            postgres    false    231            Q           2606    17076 '   appointments fk27d0xcbajwaeeun2doojsae4    FK CONSTRAINT     �   ALTER TABLE ONLY public.appointments
    ADD CONSTRAINT fk27d0xcbajwaeeun2doojsae4 FOREIGN KEY (appointment_doctor_id) REFERENCES public.doctors(doctor_id);
 Q   ALTER TABLE ONLY public.appointments DROP CONSTRAINT fk27d0xcbajwaeeun2doojsae4;
       public          postgres    false    228    221    4685            S           2606    17081 +   available_dates fk7u5funqvtlkcrft3rkhlgsyoh    FK CONSTRAINT     �   ALTER TABLE ONLY public.available_dates
    ADD CONSTRAINT fk7u5funqvtlkcrft3rkhlgsyoh FOREIGN KEY (available_doctor_id) REFERENCES public.doctors(doctor_id);
 U   ALTER TABLE ONLY public.available_dates DROP CONSTRAINT fk7u5funqvtlkcrft3rkhlgsyoh;
       public          postgres    false    228    4685    224            T           2606    17086 $   vaccines fkekhfjmpsduds8nnilqe9b467v    FK CONSTRAINT     �   ALTER TABLE ONLY public.vaccines
    ADD CONSTRAINT fkekhfjmpsduds8nnilqe9b467v FOREIGN KEY (vaccine_animal_id) REFERENCES public.animals(animal_id);
 N   ALTER TABLE ONLY public.vaccines DROP CONSTRAINT fkekhfjmpsduds8nnilqe9b467v;
       public          postgres    false    4677    231    217            P           2606    17066 #   animals fknjsvd8kplxqmf48ybxayrx6ru    FK CONSTRAINT     �   ALTER TABLE ONLY public.animals
    ADD CONSTRAINT fknjsvd8kplxqmf48ybxayrx6ru FOREIGN KEY (animal_customer_id) REFERENCES public.customers(customer_id);
 M   ALTER TABLE ONLY public.animals DROP CONSTRAINT fknjsvd8kplxqmf48ybxayrx6ru;
       public          postgres    false    226    217    4683            R           2606    17071 (   appointments fko4t945rb708af9ry6syof7bwt    FK CONSTRAINT     �   ALTER TABLE ONLY public.appointments
    ADD CONSTRAINT fko4t945rb708af9ry6syof7bwt FOREIGN KEY (appointment_animal_id) REFERENCES public.animals(animal_id);
 R   ALTER TABLE ONLY public.appointments DROP CONSTRAINT fko4t945rb708af9ry6syof7bwt;
       public          postgres    false    217    4677    221            �   �   x�=�M
�0����.����ˊu!]��4$�H�P��=��Z�Y>�|�RJhA� ���:�ЫNV�D4�:���V�4�"Y���u;⫗=��~�LF	�	X)�@�M�h�DXW?�ӆy
C�n)��2V��w^�U�F������[�N6ь�鲉~
gY���d=�      �      x������ � �      �   6   x�-���PD���^4����:DC2��q]�C����� �m��=B�-���      �     x�U����0���S����Uo���Ҋ���T�R4$S2�� �A
/З��c����v�@}�����q�Z~�#�T�:)���k�x���t�P�M��mN�L�q��h�T����1�f�D�q�
(�ûA����u�C�m��V�ź��?r|�����,�:fӪ��]��6�<�Rζ�����f���H�$K��Lc�k.�Q�P�sMݪv$�xO����ʴF6�l8������8:��7hH��C�HC�E��y�gU㯤������`S����2�$:�l6`ο�\�{%VX�G���x�֓j�xE�u�[C5��1�34zVM�
���||y��!�B[�FB>�gPhJ�7y�x�"��n�sQIk,��td`KC��O�Cf�vl/m�`��+0^9���,X~䓦Y'�ҡ�׺��I��_P,TS��D�yy��*~���-07�`=�;zݒg��~ʐ���O]� e�$�����q��%�)�      �   �   x�e�Mj�0FףS���Fv�k Y���+�(�dǒb��P�2�Br�^�(.|1��`r]����.a��F^N���2MU���ɳݤ����Ã~���d�DDH��wNz����Z.Ӹ�>8e�1���o�����M�I?��޻s�0�ڠ{��O�j��6 8�$Fq�ԙ�#���ηPt	��^�B��©�~4��&��{�WAH�����m��='��9*b�C1��B~ D;{�      �   �   x�-���0Dg�_\�&ul�#K�.�hT$��}�$�<�����zϢdb��  ����s~;�˕e�IV%&��q]S�ե�Ɓ%PF� �og�G��Q��w6��i�֧j���X7�q0��������'�     