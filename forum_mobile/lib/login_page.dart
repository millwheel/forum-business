import 'package:flutter/material.dart';
import 'package:forum_mobile/component/common_outlined_button.dart';
import 'package:forum_mobile/main.dart';
import 'package:forum_mobile/service/auth_service.dart';
import 'package:provider/provider.dart';

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
              TopSpace(),
              Center(
                child: Text(
                  "Login",
                  style: TextStyle(fontSize: 32, fontWeight: FontWeight.w500),
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
    return Consumer<AuthService>(
      builder: (context, authService, child) {
        return Scaffold(
          backgroundColor: Colors.white,
          body: SafeArea(
            child: SingleChildScrollView(
              padding: const EdgeInsets.all(16),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.stretch,
                children: [
                  TopSpace(),
                  Text(
                    "Login with Email",
                    style: TextStyle(fontSize: 32, fontWeight: FontWeight.w500),
                  ),
                  SizedBox(
                    height: 30,
                  ),
                  SizedBox(
                    width: 300,
                    height: 60,
                    child: TextField(
                      controller: emailController,
                      decoration: InputDecoration(hintText: "Email"),
                      style: TextStyle(color: Colors.black, fontSize: 22),
                    ),
                  ),
                  SizedBox(
                    width: 300,
                    height: 60,
                    child: TextField(
                      controller: passwordController,
                      obscureText: true, // 비밀번호 안보이게
                      decoration: InputDecoration(hintText: "Password"),
                      style: TextStyle(color: Colors.black, fontSize: 22),
                    ),
                  ),
                  SizedBox(
                    height: 50,
                  ),
                  CommonElevatedButton(
                    text: "Login",
                    onPressed: () {
                      authService.signIn(
                        email: emailController.text,
                        password: passwordController.text,
                        onSuccess: () {
                          ScaffoldMessenger.of(context).showSnackBar(SnackBar(
                            content: Text("Login Success"),
                          ));
                          Navigator.pushReplacement(
                            context,
                            MaterialPageRoute(builder: (context) => HomePage()),
                          );
                        },
                        onError: (err) {
                          ScaffoldMessenger.of(context).showSnackBar(SnackBar(
                            content: Text(err),
                          ));
                        },
                      );
                    },
                    backgroundColor: Colors.blue,
                  ),
                  SizedBox(
                    height: 120,
                  ),
                  CommonElevatedButton(
                    text: "Go back",
                    onPressed: () => Navigator.pop(context),
                  ),
                  BottomSpace()
                ],
              ),
            ),
          ),
        );
      },
    );
  }
}
