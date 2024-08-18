import 'package:firebase_auth/firebase_auth.dart';
import 'package:firebase_core/firebase_core.dart';
import 'package:forum_mobile/component/bottom_space.dart';
import 'package:forum_mobile/service/auth_service.dart';
import 'package:provider/provider.dart';
import 'firebase_options.dart';
import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';

import 'component/common_elevated_button.dart';
import 'component/head_space.dart';
import 'onboarding_page.dart';


late SharedPreferences preferences;

void main() async {
  // main() 함수에서 async를 사용하려면 필요함. 일종의 약속
  WidgetsFlutterBinding.ensureInitialized();

  // shared_preferences 인스턴스 생성
  // 기기에 파일로 정보를 저장하는 방법
  preferences = await SharedPreferences.getInstance();

  // firebase app start
  await Firebase.initializeApp(
    options: DefaultFirebaseOptions.currentPlatform,
  );

  runApp(
    MultiProvider(
      providers: [
        ChangeNotifierProvider(create: (context) => AuthService()),
      ],
      child: const MyApp(),
    ),
  );
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    User? user = context.read<AuthService>().currentUser();
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Forum app',
      theme: ThemeData(
        useMaterial3: true,
      ),
      home: user == null ? OnBoarding() : HomePage(),
    );
  }
}

class HomePage extends StatelessWidget {
  const HomePage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SafeArea(
        child: Column(
          children: [
            TopSpace(),
            Center(
              child: Text(
                "home",
                style: TextStyle(fontSize: 28),
              ),
            ),
            Spacer(),
            CommonElevatedButton(
              text: '로그아웃',
              onPressed: () {
                context.read<AuthService>().signOut();
                ScaffoldMessenger.of(context).showSnackBar(SnackBar(
                  content: Text("Log out Success"),
                ));
                Navigator.pushReplacement(
                  context,
                  MaterialPageRoute(builder: (context) => OnBoarding()),
                );
              },
            ),
            BottomSpace(),
          ],
        ),
      ),
    );
  }
}
