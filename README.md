# human-resource-management-system
Sistemimiz üç temel kullanıcı türüne sahiptir. Sistem personeli, İş Arayanlar ve İş verenler. Sistem 
personeli : Projenizde çalışan kişiler. Örneğin Kariyer.Net personeli.
ÖNEMLİ : Burada ilk etapta veri tabanı modeli istiyorum. Kod yazmanızı istemiyorum.
Req 1 : İş Arayanlar sisteme kayıt olabilmelidir.
Kabul Kriterleri:
Kayıt sırasında kullanıcıdan ad, soyad, tcno, doğum yılı, e-Posta, şifre, şifre tekrarı bilgileri istenir.
Tüm alanlar zorunludur. Kullanıcı bilgilendirilir.
Mernis doğrulaması yapılarak sisteme kayıt gerçekleştirilir.
Doğrulama geçerli değilse kullanıcı bilgilendirilir.
Daha önce kayıtlı bir e-posta veya tcno var ise kayıt gerçekleşmez. Kullanıcı bilgilendirilir.
Kayıdın gerçekleşmesi için e-posta doğrulaması gerekir.
Req 2 : İş verenler sisteme kayıt olabilmelidir.
Kabul Kriterleri:
Kayıt sırasında kullanıcıdan şirket adı, web sitesi, web sitesi ile aynı domaine sahip e-posta, telefon, 
şifre, şifre tekrarı bilgileri istenir. Burada amaç sisteme şirket olmayanların katılmasını engellemektir.
Tüm alanlar zorunludur. Kullanıcı bilgilendirilir.
Şirket kayıtları iki şekilde doğrulanır. Kayıdın gerçekleşmesi için e-posta doğrulaması gerekir. HRMS 
personelinin (bizim :)) onayı gerekmektedir.
Daha önce kayıtlı bir e-posta var ise kayıt gerçekleşmez. Kullanıcı bilgilendirilir.
Req 3 : Sisteme genel iş pozisyonu isimleri eklenebilmelidir. Örneğin Software Developer, Software 
Architect.
Kabul Kriterleri:
Bu pozisyonlar tekrar edemez. Kullanıcı uyarılır.
Spring Boot ile hrms isimli projenizi oluşturunuz.
Katmanları yazınız.
Sistemde bulunan genel iş pozisyonlarını listeleyecek api'yi yazınız
Daha önce modellemesini yaptığınız aşağıdaki gereksinimleri koda dökünüz. 
ÖNEMLİ 1 : Doğrulama işlemleri için sahte servisler oluşturunuz. Örneğin, gerçekten mail göndermeniz 
gerekmez.
ÖNEMLİ 2 : Gereksinimler dışında kodlama yapmayınız. Bu, Proje yönetimi ve ALM (Application 
LifeCycle Management) kurallarına aykırı bir yazılım geliştirici davranışıdır.
Req 1 : İş Arayanlar sisteme kayıt olabilmelidir.
Kabul Kriterleri:
Kayıt sırasında kullanıcıdan ad, soyad, tcno, doğum yılı, e-Posta, şifre, şifre tekrarı bilgileri istenir.
Tüm alanlar zorunludur. Kullanıcı bilgilendirilir.
Mernis doğrulaması yapılarak sisteme kayıt gerçekleştirilir.
Doğrulama geçerli değilse kullanıcı bilgilendirilir.
Daha önce kayıtlı bir e-posta veya tcno var ise kayıt gerçekleşmez. Kullanıcı bilgilendirilir.
Kayıdın gerçekleşmesi için e-posta doğrulaması gerekir.
Req 2 : İş verenler sisteme kayıt olabilmelidir.
Kabul Kriterleri:
Kayıt sırasında kullanıcıdan şirket adı, web sitesi, web sitesi ile aynı domaine sahip e-posta, telefon, 
şifre, şifre tekrarı bilgileri istenir. Burada amaç sisteme şirket olmayanların katılmasını engellemektir.
Tüm alanlar zorunludur. Kullanıcı bilgilendirilir.
Şirket kayıtları iki şekilde doğrulanır. Kayıdın gerçekleşmesi için e-posta doğrulaması gerekir. HRMS 
personelinin (bizim :)) onayı gerekmektedir.
Daha önce kayıtlı bir e-posta var ise kayıt gerçekleşmez. Kullanıcı bilgilendirilir.
Req 3 : Sisteme genel iş pozisyonu isimleri eklenebilmelidir. Örneğin Software Developer, Software 
Architect.
Kabul Kriterleri:
Bu pozisyonlar tekrar edemez. Kullanıcı uyarılır.
Req 4 : İş verenler listelenebilmelidir. (Sadece tüm liste)
Req 5 : İş arayanlar listelenebilmelidir. (Sadece tüm liste)
Req 6 : İş pozisyonları listelenebilmelidir. (Sadece tüm liste
