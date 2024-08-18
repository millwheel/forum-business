import 'package:flutter/material.dart';
import 'package:forum_mobile/component/common_outlined_button.dart';

import 'component/bottom_space.dart';
import 'component/common_elevated_button.dart';
import 'component/head_space.dart';

class LoginPage extends StatelessWidget {
  const LoginPage({super.key});

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
              Center(
                child: Text(
                  "Login",
                  style: TextStyle(fontSize: 30),
                ),
              ),
              SizedBox(
                height: 36,
              ),
              CommonOutlinedButton(
                text: "Google login",
                onPressed: () {},
              ),
              SizedBox(
                height: 20,
              ),
              CommonOutlinedButton(
                text: "Kakao login",
                onPressed: () {},
              ),
              SizedBox(
                height: 20,
              ),
              CommonOutlinedButton(
                text: "Email login",
                onPressed: () {
                  Navigator.push(
                    context,
                    MaterialPageRoute(builder: (context) => EmailLoginPage()),
                  );
                },
              ),
              const Spacer(),
              CommonElevatedButton(
                text: "Go back",
                onPressed: () {
                  Navigator.pop(context);
                },
              ),
              BottomSpace(),
            ],
          ),
        ),
      ),
    );
  }
}

class EmailLoginPage extends StatefulWidget {
  const EmailLoginPage({super.key});

  @override
  State<EmailLoginPage> createState() => _EmailLoginPageState();
}

class _EmailLoginPageState extends State<EmailLoginPage> {
  TextEditingController emailController = TextEditingController();
  TextEditingController passwordController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white,
      body: SafeArea(
        child: SizedBox(
          width: double.infinity,
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.center,
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Text(
                "로그인",
                style: TextStyle(fontSize: 28),
              ),
              SizedBox(
                width: 300,
                height: 60,
                child: TextField(
                  controller: emailController,
                  decoration: InputDecoration(hintText: "이메일"),
                  style: TextStyle(color: Colors.black, fontSize: 22),
                ),
              ),
              SizedBox(
                width: 300,
                height: 60,
                child: TextField(
                  controller: passwordController,
                  obscureText: false, // 비밀번호 안보이게
                  decoration: InputDecoration(hintText: "비밀번호"),
                  style: TextStyle(color: Colors.black, fontSize: 22),
                ),
              ),
              SizedBox(
                height: 60,
              ),
              CommonElevatedButton(
                text: "로그인",
                onPressed: () {},
                backgroundColor: Colors.blue,
              )
            ],
          ),
        ),
      ),
    );
  }
}