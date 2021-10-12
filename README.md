[![wakatime](https://wakatime.com/badge/user/0671d7a1-0f1f-4dae-9501-2d7aa4f6fc20/project/d25bb704-66db-4dfa-8f53-5499c6698536.svg)](https://wakatime.com/badge/user/0671d7a1-0f1f-4dae-9501-2d7aa4f6fc20/project/d25bb704-66db-4dfa-8f53-5499c6698536)
## English
<p>
In this project, I try to simulate how file encryption viruses work for study and research purposes only, so I used the dry language
Because it is a language that is not suitable for doing such things in the real world because it is slow and easy to discover
</p>
<h3> What happens when you run a virus? </h3>
<p>
In the case of Windows
</p>
<ol>
<li><bdi>Which indicates that the program is already running does not exist, that is, there is no other copy of it that works</bdi> anas.op <bdi> The virus makes sure that the file</bdi></li>
<li>If the file does not exist, it will create one and continue working</li>
<li>Generates a 16-character encryption key and a 20-character victim ID</li>
<li>Supposed to send them to the attacker's database, but this part hasn't been completed yet</li>
<li>Creates an object that represents a readme file that contains the victim ID and the amount required for the encryption key (and the encryption key temporarily)</li>
<li>Fetches the victim's parcels</li>
<li>It checks all the files inside a particular partition and makes sure that it is writable and that it is not a file belonging to the operating system</li>
<li>It sends the files obtained after scanning and filtering to the class responsible for managing the encryption process, which in turn sends the files, a file file to the encryption class, and makes sure that the encryption is successful, then deletes the original file</li>
<li>When the virus has finished encrypting all files within a particular partition, it will place the Read Me file inside the partition and continue to the next part</li>
<li>When the file encryption process is completed in all partitions, the virus creates an associated file on the desktop </li>
<li><bdi>And close</bdi> anas.op <bdi>Then delete the file</bdi></li>
</ol>
<h3> What happens when I run the file decryption tool? </h3>
<p>
In the case of Windows
</p>
<ol>
<li><bdi>Which indicates that the program is already running does not exist, that is, there is no other copy of it that works</bdi> anas.op <bdi> The virus makes sure that the file</bdi></li>
<li>If the file does not exist, it will create one and continue working</li>
<li>A very simple graphical interface appears asking the user to enter the decryption key</li>
<li>
When you press the decrypt button, the program checks the length of the key and makes sure that it is equal to 16, and then sends a request to the Fetch files class to check the files for a sample
<ul>
<li>If it finds a sample, it sends it to the decryption class to test the key</li>
<li><bdi>Close</bdi> anas.op <bdi>If no sample is found, it will display an error message and delete the file</bdi></li>
</ul>
</li>
<li>It calls the decryption auxiliary class, which in turn checks all the encrypted files inside a particular partition and sends them a file file to the decryption function and makes sure that the decryption process is successful and then deletes the encrypted file</li>
<li><bdi>Check that the deletion process was successful and then close</bdi> anas.op <bdi>When you close the tool, it hides the window and deletes the file </bdi></li>
</ol>
<hr>
<p>I am not responsible for any use outside the framework of study and research, and I am not responsible for any damage resulting from any use outside this framework or resulting from use without sufficient experience</p>

## Arabic

<p align="right">
في هذا المشروع احاول محاكة طريقة عمل فايروسات تشفير الملفات لأغراض الدراسة والبحث فقط ولذالك استخدمت لغة الجافة
لانها لغة غير مناسبة لعمل مثل هذة الاشياء في العالم الحقيقي بسبب بطئها وسهولة اكتشافها
</p>
<h3 align="right"> مالذي يحدث عند تشغيل الفيروس؟ </h3>
<p align="right">
في حالة الويندوز
</p>
<ol align="right">
<li><bdi>والذي يدل علي ان البرنامج يعمل بالفعل غير موجود اي انه لا يوجد نسخة اخري منه تعمل</bdi> anas.op <bdi> يقوم الفايروس بالتأكد من ان ملف</bdi></li>
<li>واذا لم يجد الملف موجود يقوم بإنشاء واحد  ومتابعة العمل</li>
<li>يقوم بأنشاء مفتاح تشفير يتكون من 16 حرف ورقم تعريفي للضحية يتكون من 20 حرفا</li>
<li>المفترض ان يقوم بإرسالهما الي قاعدة بيانات المهاجم، لكن هذة الجزئية لم تكتمل بعد</li>
<li>يقوم بإنشاء كائن يمثل ملف إقرأني يعتوي علي الرقم التعريفي للضحية والمبلغ المطلوب لأجل مفتاح التشفير(ومفتاح التشفير مؤقتا)</li>
<li>يقوم بجلب البارتشانات الخاصة بالضحية</li>
<li>يقوم بفحص جميع الملفات التي بداخل بارتشن معين ويتأكد من انها قابلة للكتابة عليها وانها ليست ملف تابع لنظام التشغيل</li>
<li>يقوم بإرسال الملفات حصل عليها بعد الفحص والفلترة الي الكلاس المسؤل عن ادارة عملية التشفير والذي بدوره يقوم بإرسال الملفات ملف ملف الي كلاس التشفير والتأكد من ان التشفير تم بنجاح ثم يقوم بحذف الملف الاصلي</li>
<li>عند انتاهء الفايروس من تشفير جميع الملفات بداخل بارتشن معين يقوم بوضع ملف اقرأني بداخل البارتشن والمتابعة الي البارتشن التالي</li>
<li>عند انتهاء عملية تشفير الملفات في جميع البارتشنات يقوم الفايروس بأنشاء ملف اقراني علي سطح المكتب </li>
<li><bdi>والاغلاق</bdi> anas.op <bdi>ثم يقوم بحذف ملف</bdi></li>
</ol>
<h3 align="right"> مالذي يحدث عند تشغيل اداة فك تشفير الملفات؟ </h3>
<p align="right">
في حالة الويندوز
</p>
<ol align="right">
<li><bdi>والذي يدل علي ان البرنامج يعمل بالفعل غير موجود اي انه لا يوجد نسخة اخري منه تعمل</bdi> anas.op <bdi> يقوم الفايروس بالتأكد من ان ملف</bdi></li>
<li>واذا لم يجد الملف موجود يقوم بإنشاء واحد  ومتابعة العمل</li>
<li>يظهر واجة رسومية بسيطة جدا تطلب من المستخدم ادخال مفتاح فك التشفير</li>
<li>
عند الضغط علي زر فك التشفير يقوم البرنام بالتحقق من طول المفتاح والتأكد انه يساوي 16 ومن ثم يرسل طلب الي كلاس جلب الملفات لفحص الملفات بحثأ عن عينة
<ul>
<li>إذا وجد عينة يقوم بإرسالها الي كلاس فك التشفير لإختبار المفتاح</li>
<li><bdi>والإغلاق</bdi> anas.op <bdi>واذا لم يجد عينة يقوم بإظهار سالة خطأ وحذف ملف</bdi></li>
</ul>
</li>
<li>يقوم بإستدعاء الكلاس المساعد لفك التشفير، والذي يقوم بدورة بفحص جميع الملفات المشفرة بداخل بارتشن معين واساللها ملف ملف الي دالة فك التشفير والتأكد من نجاح عملية الفك ثم يقوم بحذف الملف المشفر</li>
<li><bdi>و التأكد من ان عملية الحذف قد تمت بنجاح ثم الاغلاق</bdi> anas.op <bdi>عند اغلاق الأداة تقوم بإخفاء النافذة وحذف ملف </bdi></li>
</ol>
<hr>
<p align="right">أنا غير مسؤل عن اي استخدام خارج اطار الدراسة والبحث ولست مسؤل عن اي ضرر ناتج عن اي استخدام خارج هذا الاطار او ناتج عن الاستخدام من دون امتلاك الخبرة الكافية</p>
