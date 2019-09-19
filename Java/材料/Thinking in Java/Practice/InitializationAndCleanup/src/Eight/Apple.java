package Eight;

class Apple {
    Apple getPeeled(){
        return Peeler.peel(this);
    }
}
