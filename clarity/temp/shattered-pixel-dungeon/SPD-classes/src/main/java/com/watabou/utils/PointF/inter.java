class Snippet {
        public static PointF inter(PointF a, PointF b, float d){
            return new PointF(a.x + (b.x - a.x) * d, a.y + (b.y - a.y) * d);
        }
}