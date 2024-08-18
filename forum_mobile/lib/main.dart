import 'dart:async';

import 'package:firebase_core/firebase_core.dart';
import 'firebase_options.dart';
import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';

import 'component/common_elevated_button.dart';
import 'component/head_space.dart';

import 'join.dart';
import 'login.dart';

late SharedPreferences preferences;

void main() async {
  // main() 함수에서 async를 사용하려면 필요함. 일종의 약속
  WidgetsFlutterBinding.ensureInitialized();

  // shared_preferences 인스턴스 생성
  // 기기에 파일로 정보를 저장하는 방법
  preferences = await SharedPreferences.getInstance();

  // firebase setting
  await Firebase.initializeApp(
    options: DefaultFirebaseOptions.currentPlatform,
  );

  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    bool isOnboarded = preferences.getBool("isOnboarded") ?? false;
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Flutter Demo',
      theme: ThemeData(
        useMaterial3: true,
      ),
      home: isOnboarded ? HomePage() : OnBoarding(),
    );
  }
}

class OnBoarding extends StatefulWidget {
  const OnBoarding({super.key});

  @override
  State<OnBoarding> createState() => _OnBoardingState();
}

class _OnBoardingState extends State<OnBoarding> {
  double _opacity = 0.0;

  @override
  void initState() {
    super.initState();

    Future.delayed(const Duration(milliseconds: 1500), () {
      setState(() {
        _opacity = 1.0;
      });
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white,
      body: SafeArea(
        child: SizedBox(
          width: double.infinity,
          child: Column(
            children: [
              HeadSpace(),
              AnimatedOpacity(
                opacity: _opacity,
                duration: const Duration(seconds: 2),
                child: Text(
                  textAlign: TextAlign.center,
                  "Make a friend who is reliable.",
                  style: TextStyle(fontSize: 26),
                ),
              ),
              const Spacer(),
              Padding(
                padding: EdgeInsets.only(bottom: 60),
                child: Column(
                  children: [
                    CommonElevatedButton(
                      text: "Login",
                      onPressed: () {
                        Navigator.push(
                          context,
                          MaterialPageRoute(builder: (context) => LoginPage()),
                        );
                      },
                      backgroundColor: Colors.lightBlue,
                    ),
                    SizedBox(
                      height: 20,
                    ),
                    CommonElevatedButton(
                      text: "Join",
                      onPressed: () {
                        Navigator.push(
                          context,
                          MaterialPageRoute(builder: (context) => JoinPage()),
                        );
                      },
                      fontColor: Colors.white,
                      backgroundColor: Colors.black,
                    ),
                  ],
                ),
              )
            ],
          ),
        ),
      ),
    );
  }
}

class HomePage extends StatelessWidget {
  const HomePage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Column(
        children: [
          Center(
            child: Text("home"),
          ),
        ],
      ),
    );
  }
}
