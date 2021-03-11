package com.android.tallybook.mvp;

public interface IWelcome {
    interface V{
        /**
         * 判断是否是第一次进入app
         */
        void firstEntetrJudge();

        /**
         * @param flag true跳转程序主页面,false显示错误信息
         *
         * @param information 错误信息
         */
        void hasLogin(boolean flag,String information);
    }
    interface P{
        /**
         * 通过读取shareprefence进行判断
         * false：第一次进入app
         *        跳转引导界面
         * true：不是第一次进入
         *      进行用户登入判断
         */
        void firstEntetrJudge();

        /**
         * 判断本地是否保存已登录用户
         * 根据mModel.getContract().hasLogin()返回判断
         * false：不存在已登录用户或登录信息错误
         * ture:为成功跳转程序主页面
         */
        void hasLogin();
    }
    interface M{

        /**
         * 通过读取shareprefence中存取的数据
         * 进行用户校验（使用sqlite，正式开发进行联网验证）
         * @return 返回false为用户没有登录或者用户登录信息错误
         *          true为成功跳转程序主页面
         */
        boolean hasLogin();
    }
}
